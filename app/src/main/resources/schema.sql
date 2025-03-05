DROP TABLE IF EXISTS conversation;
CREATE TABLE conversation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    message TEXT,
    date TIMESTAMP,
    citation TEXT
);