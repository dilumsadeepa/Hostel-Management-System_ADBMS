CREATE TABLE complaint(
    complaint_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    user_id int NOT NULL,
    user_index VARCHAR(255) NOT NULL,
    complaint TEXT(2000) NOT NULL,
    res_id int NOT NULL,
    complaint_date DATE COMMENT 'Create Time',
    evidence_image VARCHAR(255) NULL,
    status VARCHAR(255) DEFAULT 'pending',
    is_deleted BOOLEAN DEFAULT 0,
    Foreign Key (user_id) REFERENCES users(id),
    Foreign Key (user_index) REFERENCES users(index_no),
    Foreign Key (res_id) REFERENCES resource(res_id)
)

INSERT INTO complaint (user_id, user_index, complaint, res_id, complaint_date, evidence_image, status)
VALUES
    (1, 'TG006', 'Broken chair in room 204', 1, '2023-11-03', 'https://images.squarespace-cdn.com/content/v1/55803cbbe4b0206c1dc1d585/1447412964043-BXC3RQCLUVWAGZRW9SKZ/IMG_1796.JPG', 'pending'),
    (2, 'TG001', 'Broken cupboard in room 102', 2, '2023-10-28', null, 'In Progress'),
    (3, 'TG002', 'Broken fan in room 105', 3, '2023-10-28', null, 'Resolved'),
    (4, 'TG003', 'Broken table in room 105', 4, '2023-10-20', 'https://mvflaim.files.wordpress.com/2021/05/20210516_123229.jpg', 'pending'),
    (5, 'TG005', 'Broken chair in room 107', 5, '2023-10-28', 'https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg', 'pending'),
    (6, 'TG004', 'Broken chair in room 103', 5, '2023-10-28', 'https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg', 'pending');


-- retrieves all complaints for a particular user_index
DELIMITER $$

CREATE PROCEDURE GetComplaintsByUserIndex(IN in_user_index VARCHAR(255))
BEGIN
    SELECT * FROM complaint WHERE user_index = in_user_index;
END $$

DELIMITER ;

CALL GetComplaintsByUserIndex('TG001');


-- retrieves all complaints for a particular complaint_date,

DELIMITER $$

CREATE PROCEDURE GetComplaintsByDate(IN in_complaint_date DATETIME)
BEGIN
    SELECT * FROM complaint WHERE complaint_date = in_complaint_date;
END $$

DELIMITER ;

CALL GetComplaintsByDate('2023-10-28')








CREATE TABLE resource_categories (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);


INSERT INTO resource_categories (category_name) VALUES
    ('cupboard'),
    ('chair'),
    ('table'),
    ('bed'),
    ('mattress'),
    ('bulb'),
    ('fan'),
    ('towel rack'),
    ('toilet'),
    ('shower'),
    ('sink'),
    ('mirror'),
    ('tap'),
    ('towel');

CREATE TABLE `resource` (
  `res_id` int NOT NULL AUTO_INCREMENT,
  `res_category_id` int,
  `room_no` int DEFAULT NULL,
  `res_name` varchar(255) DEFAULT NULL,
  `installation_date` date DEFAULT NULL,
  `last_maintenance_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) 



CREATE TABLE db_notifications (
    notification_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    notification_category VARCHAR(100) NOT NULL,
    notification_title VARCHAR(255) NOT NULL,
    msg TEXT NULL,
    to_whom INT NOT NULL,
    create_date DATE DEFAULT (CURRENT_DATE),
    notify_date DATE NULL,
    key_id INT NULL,
    notify_status VARCHAR(255) NULL
);
