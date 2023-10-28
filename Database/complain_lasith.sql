CREATE TABLE complaint(
    complaint_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    user_id VARCHAR(255) NOT NULL,
    complaint TEXT(1000) NOT NULL,
    res_id VARCHAR(255) NOT NULL,
    complaint_date DATETIME COMMENT 'Create Time',
    email VARCHAR(255),
    phone VARCHAR(255),
    message VARCHAR(255)
) COMMENT '';
)