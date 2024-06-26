CREATE TABLE CATEGORY (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE PRODUCT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(1000),
    PRICE DECIMAL(10, 2) NOT NULL,
    CATEGORY_ID BIGINT,
    AVAILABLE BOOLEAN NOT NULL,
    QUANTITY INT NOT NULL DEFAULT 0,
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(ID)
);

CREATE TABLE PERSON (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(255) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL
);

CREATE TABLE ROLE (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE USER_ROLES (
    USER_ID BIGINT NOT NULL,
    ROLE_ID BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES PERSON(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES ROLE(id) ON DELETE CASCADE
);
