USE rank;

CREATE TABLE teacher_stats (
    teacher_id BIGINT PRIMARY KEY,
    lessons INT NOT NULL DEFAULT 0,
    views INT NOT NULL DEFAULT 0,
    total_score BIGINT NOT NULL DEFAULT 0,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);