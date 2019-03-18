import React, { Component } from 'react';
import styled from 'styled-components';

const TodoItemDiv = styled.div`
  width: 200px;
  height: 130px;
  background-color: papayawhip;
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
      <TodoItemDiv>
        <IdP>{id}</IdP>
        <p>{{completed} === true ? '완료' : '미완료'}</p>
        <TitleHeader>{title}</TitleHeader>
        <p>{content}</p>
        <p>{createdAt}</p>
      </TodoItemDiv>
    );
  }
}

export default TodoItem;