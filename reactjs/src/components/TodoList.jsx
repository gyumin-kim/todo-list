import React, { Component } from 'react';
import styled from 'styled-components';
import TodoNoPriority from './TodoNoPriority';
import Todo3rdPriority from './Todo3rdPriority';
import Todo2ndPriority from './Todo2ndPriority';
import Todo1stPriority from './Todo1stPriority';

const AllListDiv = styled.div`
  display: flex;
  width: 90%;
  margin: 100px auto;
  justify-content: space-around;
`;

class TodoList extends Component {
  render() {
    return (
      <AllListDiv>
        <TodoNoPriority />
        <Todo3rdPriority />
        <Todo2ndPriority />
        <Todo1stPriority />
      </AllListDiv>
    );
  }
};

export default TodoList;