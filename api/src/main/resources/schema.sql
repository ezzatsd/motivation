DROP TABLE IF EXISTS quote;
CREATE TABLE quote (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);