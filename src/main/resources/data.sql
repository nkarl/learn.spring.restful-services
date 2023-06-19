INSERT INTO user_details(id, birth_date, name)
VALUES (10001, current_date(), 'Karl');
INSERT INTO user_details(id, birth_date, name)
VALUES (10002, current_date(), 'Ann');
INSERT INTO user_details(id, birth_date, name)
VALUES (10003, current_date(), 'John');
INSERT INTO user_details(id, birth_date, name)
VALUES (10004, current_date(), 'James');

INSERT INTO post(id, description, user_id)
values(20001, 'I want to learn AWS.', 10001);
INSERT INTO post(id, description, user_id)
values(20002, 'I want to learn DevOps.', 10001);
INSERT INTO post(id, description, user_id)
values(20003, 'I want to get AWS Certificate.', 10002);
INSERT INTO post(id, description, user_id)
values(20004, 'I want to learn MultiCloud.', 10002);
