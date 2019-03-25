import React, { Component } from 'react';
import DatePicker from 'react-datepicker';

import "react-datepicker/dist/react-datepicker.css";

class TodoInput extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // deadline: new Date('2020-01-01 09:30:00'),
    }
  }

  render() {
    return (
      <div>
        <form onSubmit={this.createNewTodo.bind(this)}>
          <label htmlFor="title">제목</label>
          <input type="text" id="title" ref={ref => {this._titleInput = ref}} autoComplete="off" /><br/>
          <label htmlFor="contents">내용</label>
          <input type="text" id="contents" ref={ref => {this._contentsInput = ref}} autoComplete="off" /><br/>
          
          <select
            ref={select => this._priority = select}>
            <option value="0">-</option>
            <option value="1">1순위</option>
            <option value="2">2순위</option>
            <option value="3">3순위</option>
          </select> <br/>

          <DatePicker 
            selected={this.state.deadline}
            onChange={this.handleDateTimeChange.bind(this)}
            showTimeSelect
            dateFormat="yyyy MMMM d h:mm aa"
            locale="ko"
          /> <br/>

          <button type="submit">추가</button>
        </form>
      </div>
    );
  }

  createNewTodo(e) {
    let title = this._titleInput.value;
    let contents = this._contentsInput.value;
    let priority = this._priority.value;
    let deadline = this.state.deadline;
    
    if (title === "") {
      alert("제목을 입력하세요")
      e.preventDefault();
      return;
    }
    if (contents === "") {
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
        deadline: deadline,
      })
    }).then(res => {
      console.log(res)
    }).catch(err => {
      console.log(err);
    })
  }

  handleDateTimeChange(date) {
    this.setState({
      deadline: date,
    });
  }
};

export default TodoInput;