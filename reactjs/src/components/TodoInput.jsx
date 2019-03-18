import React, { Component } from 'react';

class TodoInput extends Component {
  render() {
    return (
      <div>
        <form onSubmit={this.createNewTodo.bind(this)}>
          <input type="text" 
                  ref={ref => {
                    this._inputElement = ref
                  }} />
          <button type="submit">추가</button>
        </form>
      </div>
    );
  }

  createNewTodo(e) {
    let title = this._inputElement.value;
    
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
      })
    }).then(res => {
      console.log(res)
    }).catch(err => {
      console.log(err);
    })
  }
};

export default TodoInput;