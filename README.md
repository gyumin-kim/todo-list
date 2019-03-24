# todo-list
✅TODO list application — Spring Boot &amp; React

## About
Spring Boot와 React 등을 적용한 TODO list 애플리케이션입니다.
할 일(제목/내용), 우선순위, 마감기한 등을 지정할 수 있습니다.

## Getting Started
#### Database
1. `mysql -u root -p`
2. `create user 'todouser'@'%' identified by 'todo';`
3. `grant all on tododb.* to 'todouser'@'%';`
4. `create user 'todouser'@'localhost' identified by 'todo';`
5. `grant all on tododb.* to 'todouser'@'localhost';`
6. `flush privileges;`

#### Project
1. `git clone https://github.com/gyumin-kim/todo-list.git`
2. `cd todo-list`
3. `mvn package`
4. `java -jar target/todo-list-0.0.1-SNAPSHOT.jar`
5. `http://localhost:8080`으로 접속

## Notes
- Push notification을 위해 Firebase Cloud Messaging을 적용하였으나, 현재는 각 TODO item의 마감기한과 무관하게 일정한 시간마다 무작위로 알림이 가고 있습니다. 각 item의 완료 여부와 마감 기한에 따라 필요한 경우에만 알림이 가도록 구현할 예정입니다.
- 각 TODO item의 제목이나 우선순위 등을 변경할 경우, 페이지 전체가 re-rendering되고 있습니다. 현재의 React component 구조로는 state가 바뀔 때 바로 다른 열로 이동하고 있지 않습니다. state가 바뀜에 따라 해당 부분만 re-rendering되도록 수정할 예정입니다.
