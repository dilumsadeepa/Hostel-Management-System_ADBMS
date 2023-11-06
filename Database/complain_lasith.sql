CREATE TABLE complaint(
    complaint_id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    user_id int NOT NULL,
    user_index VARCHAR(255) NOT NULL,
    complaint TEXT(2000) NOT NULL,
    res_id int NOT NULL,
    complaint_date DATE DEFAULT (CURRENT_DATE),
    evidence_image VARCHAR(255) NULL,
    status VARCHAR(255) DEFAULT 'pending',
    is_deleted BOOLEAN DEFAULT 0,
    Foreign Key (user_id) REFERENCES users(id),
    Foreign Key (user_index) REFERENCES users(index_no),
    Foreign Key (res_id) REFERENCES resource(res_id)
)

INSERT INTO complaint (user_id, user_index, complaint, res_id, complaint_date, evidence_image, status)
VALUES
    (1, 'TG006', 'Broken chair in room 204', 16, '2023-11-03', 'https://images.squarespace-cdn.com/content/v1/55803cbbe4b0206c1dc1d585/1447412964043-BXC3RQCLUVWAGZRW9SKZ/IMG_1796.JPG', 'pending'),
    (5, 'TG005', 'Broken chair in room 107', 15, '2023-10-28', 'https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg', 'pending'),
    (6, 'TG004', 'Broken chair in room 103', 12, '2023-10-28', 'https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg', 'pending');


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

ALTER TABLE `complaintNotification` RENAME `complaint_notification`; 


-- Create a trigger to update the summary table
DELIMITER //
CREATE TRIGGER update_summary
AFTER INSERT ON resource
FOR EACH ROW
BEGIN
    IF NEW.res_name = 'chair' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'chair';
    ELSEIF NEW.res_name = 'desk' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'desk';
    ELSEIF NEW.res_name = 'lamp' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'lamp';
    ELSEIF NEW.res_name = 'fan' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'fan';
    ELSEIF NEW.res_name = 'bed' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'bed';
    ELSEIF NEW.res_name = 'cloth rack' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'cloth rack';
    ELSEIF NEW.res_name = 'cupboard' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'cupboard';
    END IF;
END;
//
DELIMITER ;


--- After Delete Trigger ---

DELIMITER $$
CREATE TRIGGER after_delete_trigger
AFTER DELETE ON resource
FOR EACH ROW
BEGIN
  INSERT INTO deleted_resource (res_id, room_no, res_name, installation_date, last_maintenance_date, status, deletion_date)
  VALUES (OLD.res_id, OLD.room_no, OLD.res_name, OLD.installation_date, OLD.last_maintenance_date, OLD.status, NOW());
END;
$$
DELIMITER ;




---- keep logs with triggers

1)firstly created table for keep logs

CREATE TABLE user_report_logs_final (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    action VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    user_id INT
);


2)then made a trigger

DELIMITER //
CREATE TRIGGER user_report_logs_final
AFTER INSERT
ON users  
FOR EACH ROW
BEGIN
    INSERT INTO user_report_logs_final (action, timestamp, id)
    VALUES ('new user added', NOW(), NEW.id); 
END;
//
DELIMITER ;