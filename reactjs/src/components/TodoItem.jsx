import React, { Component } from 'react';
import styled from 'styled-components';

// 모든 TodoItem에 공통적으로 적용할 style
const TodoItemDiv = styled.div`
  width: 300px;
  height: 220px;
  text-align: center;
`;

const IdP = styled.p`
  font-size: 10px;
`;

const TitleHeader = styled.h2`
  font-size: 14px;
  font-weight: bold;
`;

const TitleHeaderInput = styled.input`
`;

const ContentP = styled.p`
`;

const ContentPInput = styled.input`
`;

class TodoItem extends Component {
  state = {
    isUpdating: false
  }

  render() {
    const { id, completed, title, content, createdAt } = this.props;
    let titleVar;
    let contentVar;

    let isUpdating = this.state.isUpdating;
    if (!isUpdating) {
      //TODO: title, content를 하나의 변수에 다 넣어보자
      titleVar = <TitleHeader>{title}</TitleHeader>
      contentVar = <ContentP>{content}</ContentP>
    } else {
      titleVar = <TitleHeaderInput type="text" defaultValue={title} className="title-input" />
      contentVar = <ContentPInput type="text" defaultValue={content} className="content-input" />
    }

    return (
      <TodoItemDiv style={this.props.customStyle}>
        <IdP>{id}</IdP>
        <button onClick={this.deleteItem.bind(this)}>삭제</button>
        <button onClick={this.toggleUpdate.bind(this)}>수정</button>
        <p>{{completed} === true ? '완료' : '미완료'}</p>
 
        {titleVar}<br/>
        {contentVar}<br/>
        {isUpdating === true ? <button type="submit" onClick={this.submitUpdate.bind(this)}>수정 완료</button> : ''}

        <p>{createdAt}</p>
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
}

export default TodoItem;