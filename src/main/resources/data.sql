INSERT INTO todo_item_content (id, contents) VALUES (null, 'HTTP 완벽 가이드 참조');
INSERT INTO todo_item_content (id, contents) VALUES (null, '한식이나 중식 중에서');
INSERT INTO todo_item_content (id, contents) VALUES (null, '질문 리스트 정리한 것 복습');
INSERT INTO todo_item_content (id, contents) VALUES (null, '온라인? 오프라인?');
INSERT INTO todo_item_content (id, contents) VALUES (null, '유산소 운동');

INSERT INTO todo_item (id, title, is_completed, created_date, dead_line, priority, todo_item_content_id)
VALUES (null, 'HTTPS 공부하기', false, now(), '2019-08-21 10:00:00', 2, 1);
INSERT INTO todo_item (id, title, is_completed, created_date, dead_line, priority, todo_item_content_id)
VALUES (null, '저녁 메뉴 정하기', false, now(), '2019-08-19 18:20:00', 1, 2);
INSERT INTO todo_item (id, title, is_completed, created_date, dead_line, priority, todo_item_content_id)
VALUES (null, '면접 준비하기', false, now(), '2019-08-31 12:00:00', 0, 3);
INSERT INTO todo_item (id, title, is_completed, created_date, dead_line, priority, todo_item_content_id)
VALUES (null, '여름옷 사기', false, now(), '2019-09-01 00:00:00', 3, 4);
INSERT INTO todo_item (id, title, is_completed, created_date, dead_line, priority, todo_item_content_id)
VALUES (null, '운동하기', false, now(), '2019-09-01 00:00:00', 0, 5);