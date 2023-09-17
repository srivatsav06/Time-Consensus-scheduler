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

