import React, { Component } from 'react';
import styled from 'styled-components';
import TodoItem from './TodoItem';
import TodoNoPriority from './TodoNoPriority';
import Todo3rdPriority from './Todo3rdPriority';

const AllListDiv = styled.div`
  display: flex;
  width: 90%;
  margin: 100px auto;
`;

class TodoList extends Component {
  state = {
    todos: [],
  }

  render() {
    return (
      <AllListDiv>
        {this.state.todos}
        <TodoNoPriority />
        <Todo3rdPriority />
        {/* <Todo2ndPriority /> */}
        {/* <Todo1stPriority /> */}
      </AllListDiv>
    );
  }

  componentDidMount() {
    this.fetchItemlist();
  }

  /**
   * TODO item들을 가져온다
   */
  fetchItemlist() {
    fetch("/api/items", {
      method: "GET",
    }).then(res => res.json()
    .then(data => {
      console.log(data);
      const items = data.map(item => {
        return <TodoItem
                  key={item.id}
                  id={item.id}
                  completed={item.completed}
                  title={item.title}
                  content={item.todoItemContent}
                  createdAt={item.createdDate} />
      });

      this.setState({
        todos: items,
      })
    })).catch(err => {
      console.log(err)
    })
  }
};

export default TodoList;