-- Insert the first row
INSERT INTO roles (roleId, roleName) VALUES (0, 'admin');

-- Insert the second row
INSERT INTO roles (roleId, roleName) VALUES (1, 'student');

-- Insert the third row
INSERT INTO roles (roleId, roleName) VALUES (2, 'teacher');

-- Insert the first user
INSERT INTO users (userid,name, password, email, role_fk) VALUES (1,'User1 Name', 'User1Password', 'user1@example.com', 2);

-- Insert the second user
INSERT INTO users (userid,name, password, email, role_fk) VALUES (2,'User2 Name', 'User2Password', 'user2@example.com', 1);

-- Insert a new request
INSERT INTO requests (reqid, dateandtime, status, title, description) VALUES (1, '2023-09-17 10:00:00', 'PENDING', 'Title 1', 'Description 1');

INSERT INTO participantrequests (reqid, userid) VALUES (1, 1),(1, 2);

--Insert a new event
INSERT INTO events (eventid, title, description, dateandtime) VALUES (1, 'Sample Event', 'This is a sample event description', '2021-09-16 15:30:00');
INSERT INTO events (eventid, title, description, dateandtime) VALUES (2, 'Sample Event2', 'This is a sample event description2', '2025-09-16 15:30:00');
INSERT INTO events (eventid, title, description, dateandtime) VALUES (3, 'Sample Event2', 'This is a sample event description2', '2024-09-16 15:30:00');
INSERT INTO events (eventid, title, description, dateandtime) VALUES (4, 'Sample Event2', 'This is a sample event description2', '2030-09-16 15:30:00');
INSERT INTO events (eventid, title, description, dateandtime) VALUES (5, 'Sample Event2', 'This is a sample event description2', '2029-09-16 15:30:00');
INSERT INTO events (eventid, title, description, dateandtime) VALUES (6, 'Sample Event2', 'This is a sample event description2', '2026-09-16 15:30:00');
INSERT INTO events (eventid, title, description, dateandtime) VALUES (7, 'Sample Event2', 'This is a sample event description2', '2027-09-16 15:30:00');


INSERT INTO eventparticipants (eventid, userid) VALUES (1, 1), (1, 2),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1);
