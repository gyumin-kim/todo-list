import React, { Component } from 'react';

class TodoInput extends Component {
  render() {
    return (
      <div>
        <form onSubmit={this.createNewTodo.bind(this)}>
          <label for="title">제목</label>
          <input type="text" id="title"
                 ref={ref => {this._titleInput = ref}} /><br/>
          <label for="contents">내용</label>
          <input type="text" id="contents"
                 ref={ref => {this._contentsInput = ref}} /><br/>
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
    let contents = this._contentsInput.value;
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
        contents: contents,
      })
    }).then(res => {
      console.log(res)
    }).catch(err => {
      console.log(err);
    })
  }
};

export default TodoInput;