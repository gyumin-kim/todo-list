# todo-list
✅TODO list application — Spring Boot &amp; React

## About
Spring Boot와 React 등을 적용한 TODO list 애플리케이션입니다.
할 일(제목/내용), 우선순위, 마감기한 등을 지정할 수 있습니다.

## Getting Started
### Database
1. `create user 'todouser'@'%' identified by 'todo';`
2. `grant all on tododb.* to 'todouser'@'%';`
3. `create user 'todouser'@'localhost' identified by 'todo';`
4. `grant all on tododb.* to 'todouser'@'localhost';`
5. `flush privileges;`

### Project
1. `git clone https://github.com/gyumin-kim/todo-list.git`
2. `cd todo-list`
3. `mvn package`
4. `java -jar target/todo-list-0.0.1-SNAPSHOT.jar`
5. `http://localhost:8080`으로 접속
