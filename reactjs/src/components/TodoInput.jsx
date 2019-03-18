import React, { Component } from 'react';

class TodoInput extends Component {
  render() {
    return (
      <div>
        <form onSubmit={this.createNewTodo.bind(this)}>
          <input type="text" 
                 ref={ref => {this._titleInput = ref}} />
          <select
            ref={select => this._priority = select}>
            <option value="0">-</option>
            <option value="1">1순위</option>
            <option value="2">2순위</option>
            <option value="3">3순위</option>
          </select>

          <button type="submit">추가</button>
        </form>
      </div>
    );
  }

  createNewTodo(e) {
    let title = this._titleInput.value;
    let priority = this._priority.value;
    
    if (title === "") {
      alert("내용을 입력하세요")
      e.preventDefault();
      return;
    }

    fetch("/api/item", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        title: title,
        priority: priority,
      })
    }).then(res => {
      console.log(res)
    }).catch(err => {
      console.log(err);
    })
  }
};

export default TodoInput;