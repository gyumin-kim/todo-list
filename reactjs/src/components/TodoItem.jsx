import React, { Component } from 'react';
import styled from 'styled-components';

// 모든 TodoItem에 공통적으로 적용할 style
const TodoItemDiv = styled.div`
  width: 200px;
  height: 190px;
  text-align: center;
`;

const IdP = styled.p`
  font-size: 10px;
`;

const TitleHeader = styled.h2`
  font-size: 14px;
  font-weight: bold;
`;

class TodoItem extends Component {
  render() {
    const { id, completed, title, content, createdAt } = this.props;

    return (
      <TodoItemDiv style={this.props.customStyle}>
        <IdP>{id}</IdP>
        <button onClick={this.deleteItem.bind(this)}>삭제</button>
        <p>{{completed} === true ? '완료' : '미완료'}</p>
        <TitleHeader>{title}</TitleHeader>
        <p>{content}</p>
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
}

export default TodoItem;