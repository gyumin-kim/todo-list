import React, { Component } from 'react';
import TodoItem from './TodoItem';

class TodoNoPriority extends Component {
  state = {
    items: [],
  }

  render() {
    return (
      <div>
        {this.state.items}
      </div>
    );
  }

  componentDidMount() {
    this.fetchItemlist();
  }

  fetchItemlist() {
    fetch("/api/items/0", {
      method: "GET",
    }).then(res => res.json()
    .then(data => {
      console.log(data);

      // 우선순위(열)마다 다른 style을 여기에 적용한다.
      let itemStyle = {
        backgroundColor: '#e2dcdc',
      };
      const items = data.map(item => {
        return <TodoItem
                  key={item.id}
                  id={item.id}
                  completed={item.completed}
                  title={item.title}
                  content={item.todoItemContent.contents}
                  createdAt={item.createdDate}
                  customStyle={itemStyle} />
      });
      this.setState({
        items: items,
      })
    })).catch(err => {
      console.log(err)
    })
  }
}

export default TodoNoPriority;