USE chat;

CREATE TABLE chat_rooms
(
    id         BIGINT   NOT NULL AUTO_INCREMENT	PRIMARY KEY,
    teacher_id BIGINT   NOT NULL,
    student_id BIGINT   NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL
);