insert into user_details(id, birth_date, name) VALUES(10001,current_date(), 'Rose');
insert into user_details(id, birth_date, name) VALUES(10002,current_date(), 'Garcia');
insert into user_details(id, birth_date, name) VALUES(10003,current_date(), 'Cruz');

insert into post(id, description, user_id) VALUES(20001, 'I want to learn  AWS', 10003);
insert into post(id, description, user_id) VALUES(20002, 'I want to learn  DevOps', 10003);
insert into post(id, description, user_id) VALUES(20003, 'I want get AWS certified', 10002);
insert into post(id, description, user_id) VALUES(20004, 'I want to learn  MultiCloud', 10002);