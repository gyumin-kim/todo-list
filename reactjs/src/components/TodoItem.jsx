import React, { Component } from 'react';
import styled from 'styled-components';

// 모든 TodoItem에 공통적으로 적용할 style
const TodoItemDiv = styled.div`
  width: 200px;
  height: 130px;
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
        <p>{{completed} === true ? '완료' : '미완료'}</p>
        <TitleHeader>{title}</TitleHeader>
        <p>{content}</p>
        <p>{createdAt}</p>
      </TodoItemDiv>
    );
  }
}

export default TodoItem;