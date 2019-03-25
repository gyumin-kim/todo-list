import React, { Component } from 'react';
import styled from 'styled-components';

// 모든 TodoItem에 공통적으로 적용할 style
const TodoItemDiv = styled.div`
  width: 300px;
  height: 200px;
  text-align: center;
  border-radius: 5%;
`;

const IdP = styled.p`
  font-size: 10px;
`;

const TitleHeader = styled.h2`
  font-size: 14px;
  font-weight: bold;
`;

const CustomP = styled.p`
  margin: 0;
`;

class TodoItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isUpdating: false,
      isChecked: this.props.completed === true ? "true" : "false",
      priorityValue: this.props.priority,
    }
  }

  render() {
    const { id, title, content, createdAt, deadline } = this.props;
    let titleVar;
    let contentVar;

    let isUpdating = this.state.isUpdating;
    if (!isUpdating) {
      titleVar = <TitleHeader>{title}</TitleHeader>
      contentVar = <CustomP>{content}</CustomP>
    } else {
      titleVar = <input type="text" defaultValue={title} className="title-input" />
      contentVar = <input type="text" defaultValue={content} className="content-input" />
    }

    let deadlineDiv;
    if (deadline !== null) {
      deadlineDiv = <span>마감기한: {deadline}</span>
    } else {
      deadlineDiv = '';
    }

    return (
      <TodoItemDiv style={this.props.customStyle}>
        <IdP>{id}</IdP>
        <button onClick={this.deleteItem.bind(this)}>삭제</button>
        <button onClick={this.toggleUpdate.bind(this)}>수정</button>
        <input type="checkbox" checked={this.state.isChecked === "true" ? true : false} onChange={this.toggleCompleteCheckbox.bind(this)} />
        <select value={this.state.priorityValue} onChange={this.changePriority.bind(this)} >
          <option value="0">-</option>
          <option value="1">1순위</option>
          <option value="2">2순위</option>
          <option value="3">3순위</option>
        </select> <br/>
 
        {titleVar}<br/>
        {contentVar}<br/>
        {isUpdating === true ? <button type="submit" onClick={this.submitUpdate.bind(this)}>수정 완료</button> : ''}

        <CustomP>생성일: {createdAt}</CustomP>
        <CustomP>{deadlineDiv}</CustomP>
      </TodoItemDiv>
    );
  }

  deleteItem() {
    fetch(`/api/item/${this.props.id}`, {
      method: "DELETE",
    }).then(res => {
      console.log(res)
      console.log(`${this.props.id}번 item 삭제 요청`)
      window.location.href = '/'
    }).catch(err => {
      console.log(err)
    })
  }

  toggleUpdate() {
    this.setState({
      isUpdating: !this.state.isUpdating
    })
  }

  submitUpdate() {
    console.log(`${this.props.id}. 수정 제출`)
    let titleInput = document.querySelector('.title-input').value;
    let contentsInput = document.querySelector('.content-input').value;

    fetch(`/api/item/${this.props.id}`, {
      method: "PATCH",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: titleInput,
        contents: contentsInput,
      }),
    }).then(res => {
      console.log(res)
      window.location.href = '/'
    }).catch(err => {
      console.log(err)
    })
  }

  async toggleCompleteCheckbox() {
    console.log(`${this.props.id}번 아이템 완료 체크박스 클릭`)
    await this.setState({
      isChecked: this.state.isChecked === "true" ? "false" : "true",
    })

    fetch(`/api/item/${this.props.id}`, {
      method: "PATCH", 
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        isChecked: this.state.isChecked,
      }),
    }).then(res => {;
      console.log(res);
    }).catch(err => {
      console.log(err);
    })
  }

  async changePriority(evt) {
    await this.setState({
      priorityValue: parseInt(evt.target.value),
    })

    fetch(`/api/item/${this.props.id}`, {
      method: "PATCH", 
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        priority: this.state.priorityValue,
      }),
    }).then(res => {;
      console.log(res);
      window.location.href = '/'
    }).catch(err => {
      console.log(err);
    })
  }
}

export default TodoItem;