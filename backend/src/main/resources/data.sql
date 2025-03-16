-- init roles
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_APPROVER');
INSERT INTO role (name) VALUES ('ROLE_FINANCE');

-- Create test users
-- Password: password (BCrypt encoded)
INSERT INTO users (username, email, password)
VALUES ('user', 'user@example.com', '$2a$12$PXstAeeOUNJK4f84zKyQCekBBQhx7OnWC6m.OpIEurkUcakIpEaNC');

INSERT INTO users (username, email, password)
VALUES ('approver', 'approver@example.com', '$2a$12$gzWFyqYtwrnOBhMnxxyCFeiFpeV40HlxYx5HfmltWCLHvsrAQypdu');

INSERT INTO users (username, email, password)
VALUES ('finance', 'finance@example.com', '$2a$12$gzWFyqYtwrnOBhMnxxyCFeiFpeV40HlxYx5HfmltWCLHvsrAQypdu');

-- Assign roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- user has ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- approver has ROLE_APPROVER
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3); -- finance has ROLE_FINANCE