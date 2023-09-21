-- Insert the first row
INSERT INTO roles (roleId, roleName) VALUES (0, 'admin');

-- Insert the second row
INSERT INTO roles (roleId, roleName) VALUES (1, 'student');

-- Insert the third row
INSERT INTO roles (roleId, roleName) VALUES (2, 'teacher');

-- Insert the first user
INSERT INTO users (userid,name, password, email, role_fk) VALUES (nextval('users_seq') ,'User1 Name', 'User1Password', 'user1@example.com', 2);

-- Insert the second user
INSERT INTO users (userid,name, password, email, role_fk) VALUES (nextval('users_seq') ,'User2 Name', 'User2Password', 'user2@example.com', 1);

-- Insert a new request
INSERT INTO requests (reqid, startdateandtime, enddateandtime, status, title, description) VALUES (nextval('requests_seq'), '2023-09-17 10:00:00', '2023-09-17 11:00:00', 'PENDING', 'Title 1', 'Description 1');

INSERT INTO participantrequests (reqid, userid) VALUES (1, 1),(1, 51);

--Insert a new event
INSERT INTO events (eventid, title, description, startdateandtime, enddateandtime) VALUES (nextval('events_seq'), 'Sample Event', 'This is a sample event description', '2023-09-16 15:30:00', '2023-09-16 16:30:00');

INSERT INTO eventparticipants (eventid, userid) VALUES (1, 1), (1, 51);
