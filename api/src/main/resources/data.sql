-- Initial categories
INSERT INTO CATEGORY (NAME) VALUES ('category1'), ('category2');

-- Initial products
INSERT INTO PRODUCT (NAME, DESCRIPTION, PRICE, CATEGORY_ID, AVAILABLE) VALUES 
('Product 1', 'Description of product 1', 10.00, 1, true),
('Product 2', 'Description of product 2', 20.00, 2, true),
('Product 3', 'Description of product 3', 30.00, 1, true),
('Product 4', 'Description of product 4', 40.00, 2, true),
('Product 5', 'Description of product 5', 50.00, 1, true),
('Product 6', 'Description of product 6', 60.00, 2, true),
('Product 7', 'Description of product 7', 70.00, 1, true),
('Product 8', 'Description of product 8', 80.00, 2, true),
('Product 9', 'Description of product 9', 90.00, 1, true),
('Product 10', 'Description of product 10', 100.00, 2, true),
('Product 11', 'Description of product 11', 110.00, 1, true),
('Product 12', 'Description of product 12', 120.00, 2, true),
('Product 13', 'Description of product 13', 130.00, 1, true),
('Product 14', 'Description of product 14', 140.00, 2, true),
('Product 15', 'Description of product 15', 150.00, 1, true);

-- Initial admin user
INSERT INTO PERSON (username, password) VALUES ('user', '$2a$10$Vzz.ovJ94eUdXd1VEUBOL.Pb2Dq7XPat8v/YfqUXyBrIqDrUAuiI.');
INSERT INTO PERSON (username, password) VALUES ('admin', '$2a$10$bC9tKjmEQ6tlR010eN2Zmuo5Cb4SnnGBZ/GOgQRg0J0hr8gxoAJ7u');


INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');


INSERT INTO USER_ROLES (user_id, role_id) VALUES ((SELECT id FROM PERSON WHERE username = 'user'), (SELECT id FROM role WHERE name = 'ROLE_USER'));
INSERT INTO USER_ROLES (user_id, role_id) VALUES ((SELECT id FROM PERSON WHERE username = 'admin'), (SELECT id FROM role WHERE name = 'ROLE_USER'));
INSERT INTO USER_ROLES (user_id, role_id) VALUES ((SELECT id FROM PERSON WHERE username = 'admin'), (SELECT id FROM role WHERE name = 'ROLE_ADMIN'));


