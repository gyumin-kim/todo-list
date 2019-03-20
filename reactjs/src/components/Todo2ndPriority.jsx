import React, { Component } from 'react';
import TodoItem from './TodoItem';

class Todo2ndPriority extends Component {
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
    fetch("/api/items/2", {
      method: "GET",
    }).then(res => res.json()
    .then(data => {
      console.log(data);

      // 우선순위(열)마다 다른 style을 여기에 적용한다.
      let itemStyle = {
        backgroundColor: '#f4f5d7',
      };
      const items = data.map(item => {
        return <TodoItem
                  key={item.id}
                  id={item.id}
                  completed={item.completed}
                  title={item.title}
                  content={item.todoItemContent.contents}
                  priority={item.priority}
                  createdAt={item.createdDate}
                  deadline={item.deadline}
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

export default Todo2ndPriority;