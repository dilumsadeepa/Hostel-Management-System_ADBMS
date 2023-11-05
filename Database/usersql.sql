create table roles (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role_name varchar(50) NOT NULL
);

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  index_no VARCHAR(255) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  mobile_no VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (role) REFERENCES roles (id)
);

CREATE TABLE deletedusers (
    id INT NOT NULL AUTO_INCREMENT,
    index_no VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobile_no VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role INT NOT NULL,
    deletedate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

insert into roles (role_name) values
    ('admin'),
    ('dean'),
    ('student_counsellor'),
    ('warden'),
    ('sub_warden'),
    ('student')
;



=== procedure to store users ====

DELIMITER //

CREATE PROCEDURE InsertUserWithEncryptedPassword(
    IN p_index_no VARCHAR(20),
    IN p_name VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_tel VARCHAR(255),
    IN p_password VARCHAR(255),
    IN p_role INT
)
BEGIN
    DECLARE hashed_password VARCHAR(255);
    SET hashed_password = CONCAT('fotpwd', SHA2(p_password, 256));

    INSERT INTO users (index_no, name, email, mobile_no, password, role)
    VALUES (p_index_no, p_name, p_email, p_tel, hashed_password, p_role);
    
    SELECT COUNT(*) from users;
END;
//

DELIMITER ;


=== procedure to update users ====

DELIMITER //

CREATE PROCEDURE UpdateUser(
    IN p_id INT,
    IN p_index_no VARCHAR(20),
    IN p_name VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_tel VARCHAR(255),
    IN p_password VARCHAR(255),
    IN p_role INT
)
BEGIN
    DECLARE hashed_password VARCHAR(255);
    SET hashed_password = CONCAT('fotpwd', SHA2(p_password, 256));

    UPDATE users
    SET index_no = p_index_no,
        name = p_name,
        email = p_email,
        mobile_no = p_tel,
        password = hashed_password,
        role = p_role
    WHERE id = p_id;
    
    SELECT * FROM users where id = p_id;
END;
//

DELIMITER ;


=== trigger to insert deleteuser ===

DELIMITER //

CREATE TRIGGER before_delete_user
BEFORE DELETE ON users
FOR EACH ROW
BEGIN
    INSERT INTO deletedusers (index_no, name, email, mobile_no, password, role, deletedate)
    VALUES (OLD.index_no, OLD.name, OLD.email, OLD.mobile_no, OLD.password, OLD.role,NOW());
END;
//

DELIMITER ;



-- Insert 10 students with hashed passwords
CALL InsertUserWithEncryptedPassword('TG001', 'student1', 'student1@example.com', '1234567890', 'password1', 6);
CALL InsertUserWithEncryptedPassword('TG002', 'student2', 'student2@example.com', '1234567891', 'password2', 6);
CALL InsertUserWithEncryptedPassword('TG003', 'student3', 'student3@example.com', '1234567892', 'password3', 6);
CALL InsertUserWithEncryptedPassword('TG004', 'student4', 'student4@example.com', '1234567893', 'password4', 6);
CALL InsertUserWithEncryptedPassword('TG005', 'student5', 'student5@example.com', '1234567894', 'password5', 6);
CALL InsertUserWithEncryptedPassword('TG006', 'student6', 'student6@example.com', '1234567895', 'password6', 6);
CALL InsertUserWithEncryptedPassword('TG007', 'student7', 'student7@example.com', '1234567896', 'password7', 6);
CALL InsertUserWithEncryptedPassword('TG008', 'student8', 'student8@example.com', '1234567897', 'password8', 6);
CALL InsertUserWithEncryptedPassword('TG009', 'student9', 'student9@example.com', '1234567898', 'password9', 6);
CALL InsertUserWithEncryptedPassword('TG010', 'student10', 'student10@example.com', '1234567899', 'password10', 6);
CALL InsertUserWithEncryptedPassword('TG0013', 'student13', 'student13@example.com', '1234567813', '123456789', 6);

-- Insert 1 sub-warden with a hashed password
CALL InsertUserWithEncryptedPassword('SW001', 'subwarden', 'subwarden@example.com', '1234567800', '123456789', 5);

-- Insert 1 warden with a hashed password
CALL InsertUserWithEncryptedPassword('WO002', 'warden2', 'warden2@example.com', '1234567800', '123456789', 4);

-- Insert 1 student counselor with a hashed password
CALL InsertUserWithEncryptedPassword('SC001', 'counselor', 'counselor@example.com', '1234567802', '123456789', 3);

-- Insert 1 dean with a hashed password
CALL InsertUserWithEncryptedPassword('DE001', 'Dean', 'dean@example.com', '1234567803', '123456789', 2);




=== Athunticate user ===


DELIMITER //

CREATE PROCEDURE AuthenticateUser(
    IN p_identifier VARCHAR(255),
    IN p_password VARCHAR(255)
)
BEGIN
    
    DECLARE user_id INT;
    DECLARE user_message VARCHAR(255);
    
    
    SELECT id INTO user_id
    FROM users
    WHERE (email = p_identifier OR mobile_no = p_identifier OR index_no = p_identifier) AND password = CONCAT('fotpwd', SHA2(p_password, 256));
    
    
    IF user_id IS NOT NULL THEN
        SET user_message = 'Authentication Successful';
    ELSE
        SET user_message = 'Authentication Failed';
    END IF;
    
    
    SELECT user_message AS message, id, index_no, name, email, mobile_no, role
    FROM users
    WHERE id = user_id;
END //

DELIMITER ;

CALL AuthenticateUser('student2@example.com', 'password2');


=== hostels table ===

CREATE TABLE hostels (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hostel_name VARCHAR(255) NOT NULL,
    hostel_id VARCHAR(50) NOT NULL,
    warden_id INT NOT NULL,
    FOREIGN KEY (warden_id) REFERENCES users (id)
);


INSERT INTO hostels (hostel_name, hostel_id, warden_id)
VALUES 
    ('Boys', 'B001', 11),
    ('Girls', 'G001', 11);
    

=== Rooms table ===

CREATE TABLE rooms (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    room_num VARCHAR(12) NOT NULL,
    hostel_id INT NOT NULL,
    FOREIGN KEY (hostel_id) REFERENCES hostels (id)
);


INSERT INTO rooms (room_num, hostel_id) VALUES
    ('F1R001', 1),
    ('F1R002', 1),
    ('F1R003', 1),
    ('F1R004', 1),
    ('F1R005', 1),
    ('F1R006', 1),
    ('F1R007', 1),
    ('F1R008', 1),
    ('F1R009', 1),
    ('F1R010', 1);
    
    
=== Assets catagory ===

CREATE TABLE assets_categories (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);


INSERT INTO assets_categories (category_name) VALUES
    ('cupboard'),
    ('chair'),
    ('table'),
    ('bed'),
    ('mattress'),
    ('bulb'),
    ('fan'),
    ('towel rack');
    

=== Room Assets ===

CREATE TABLE room_assets (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    room_id INT NOT NULL,
    asset_id INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms (id),
    FOREIGN KEY (asset_id) REFERENCES assets_categories (id)
);

ALTER TABLE room_assets
ADD COLUMN no_of_assets INT NOT NULL;


=== procedire to add room assets ===

DELIMITER //

CREATE PROCEDURE InsertRoomAssets(
    IN p_room_id INT,
    IN p_assets_category_id INT,
    IN p_no_of_assets INT,
    IN p_hostel_id INT
)
BEGIN
    DECLARE current_assets INT;
    DECLARE allocated_assets INT;
    DECLARE assets_name VARCHAR(255);
    
    SELECT no_of_assets INTO current_assets
    FROM assets
    WHERE assets_category_id = p_assets_category_id AND hostel_id = p_hostel_id;
    
    SELECT category_name INTO assets_name
    FROM assets_categories
    WHERE id = p_assets_category_id;
    
    SELECT COALESCE(SUM(no_of_assets), 0) INTO allocated_assets
    FROM room_assets
    WHERE asset_id = p_assets_category_id;
    
    IF allocated_assets + p_no_of_assets <= current_assets THEN
        
        INSERT INTO room_assets (room_id, asset_id, no_of_assets)
        VALUES (p_room_id, p_assets_category_id, p_no_of_assets);
        
        
        SELECT 'Assets added successfully' AS message, current_assets - (allocated_assets + p_no_of_assets) AS total_assets;
    ELSE
        SELECT CONCAT('Insufficient assets for category: ', assets_name, '. No assets added. Current assets: ', current_assets, ', Allocated assets: ', allocated_assets) AS message, current_assets - allocated_assets AS total_assets;
    END IF;
END //

DELIMITER ;




CALL InsertRoomAssets(1, 1, 2, 1);  
CALL InsertRoomAssets(1, 2, 4, 1); 
CALL InsertRoomAssets(1, 3, 4, 1);
CALL InsertRoomAssets(1, 4, 2, 1); 
CALL InsertRoomAssets(1, 5, 4, 1); 
CALL InsertRoomAssets(1, 6, 4, 1); 
CALL InsertRoomAssets(1, 7, 1, 1);
CALL InsertRoomAssets(1, 8, 2, 1);

CALL InsertRoomAssets(2, 1, 2, 1);  
CALL InsertRoomAssets(2, 2, 4, 1); 
CALL InsertRoomAssets(2, 3, 4, 1); 
CALL InsertRoomAssets(2, 4, 2, 1); 
CALL InsertRoomAssets(2, 5, 4, 1); 
CALL InsertRoomAssets(2, 6, 4, 1);
CALL InsertRoomAssets(2, 7, 1, 1); 
CALL InsertRoomAssets(2, 8, 2, 1);  

CALL InsertRoomAssets(3, 1, 2, 1);  
CALL InsertRoomAssets(3, 2, 4, 1); 
CALL InsertRoomAssets(3, 3, 4, 1);
CALL InsertRoomAssets(3, 4, 2, 1); 
CALL InsertRoomAssets(3, 5, 4, 1);
CALL InsertRoomAssets(3, 6, 4, 1);
CALL InsertRoomAssets(3, 7, 1, 1); 
CALL InsertRoomAssets(3, 8, 2, 1); 


=== view to get all room assets ===

CREATE VIEW RoomAssetsView AS
SELECT ra.room_id, ac.category_name AS assets_category_name, SUM(ra.no_of_assets) AS total_assets
FROM room_assets ra
JOIN assets_categories ac ON ra.asset_id = ac.id
GROUP BY ac.category_name, ra.room_id;


SELECT * FROM RoomAssetsView;


=== assets table ===

CREATE TABLE assets (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    assets_category_id INT NOT NULL,
    no_of_assets INT NOT NULL,
    hostel_id INT NOT NULL,
    FOREIGN KEY (assets_category_id) REFERENCES assets_categories (id),
    FOREIGN KEY (hostel_id) REFERENCES hostels (id)
);


INSERT INTO assets (assets_category_id, no_of_assets, hostel_id) VALUES
    (1, 50, 1),
    (2, 100, 1),
    (3, 100, 1),
    (4, 50, 1),
    (5, 100, 1),
    (6, 100, 1),
    (7, 25, 1),
    (8, 50, 1);
    
    
=== create complaine table ===

CREATE TABLE complains (
    complain_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description TEXT NOT NULL,
    room_id INT NOT NULL,
    asset_id INT NOT NULL,
    evidence_image VARCHAR(255),
    date DATETIME NOT NULL,
    user_id INT NOT NULL,
    status ENUM('Open', 'Review', 'Closed') NOT NULL
);

INSERT INTO complains (description, room_id, asset_id, evidence_image, date, user_id, status)
VALUES
    ('Broken chair in room 101', 101, 2, 'chair.jpg', NOW(), 1, 'Open'),
    ('Leaking faucet in room 102', 102, 6, 'faucet.jpg', NOW(), 2, 'Open'),
    ('Light bulb out in room 103', 103, 4, 'bulb.jpg', NOW(), 3, 'Open'),
    ('Clogged sink in room 104', 104, 6, 'sink.jpg', NOW(), 4, 'Open'),
    ('Noisy fan in room 105', 105, 7, 'fan.jpg', NOW(), 5, 'Open');
    



=== maintenance table ===

CREATE TABLE maintaince (
    maintenance_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    complaint_id INT NOT NULL,
    res_id INT NOT NULL,
    handler VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    inspection_note TEXT NOT NULL,
    solution TEXT NOT NULL,
    evidence_image VARCHAR(255),
    date DATETIME NOT NULL,
    FOREIGN KEY (res_id) REFERENCES resource(res_id)
);


ALTER TABLE maintaince
ADD FOREIGN KEY (complaint_id) REFERENCES complaint (complaint_id);


=== viewcomplaint ===

CREATE VIEW ViewMaintaince AS
SELECT 
    maintaince.maintenance_id,
    maintaince.complaint_id AS maintaince_complaint_id,
    maintaince.handler AS maintaince_handler,
    maintaince.status AS maintaince_status,
    maintaince.inspection_note AS maintaince_inspection_note,
    maintaince.solution AS maintaince_solution,
    maintaince.evidence_image AS maintaince_evidence_image,
    maintaince.date AS maintaince_date,
    complaint.complaint_id AS complaint_complaint_id,
    complaint.user_id AS complaint_user_id,
    complaint.res_id AS complaint_res_id,
    users.id AS users_id,
    users.name AS users_username,
    users.email AS users_email,
    resource.res_id AS resource_res_id,
    resource.res_name AS resource_res_name
FROM maintaince
JOIN complaint ON maintaince.complaint_id = complaint.complaint_id
JOIN users ON complaint.user_id = users.id
JOIN resource ON complaint.res_id = resource.res_id;


INSERT INTO maintaince (complaint_id, handler, status, inspection_note, solution, evidence_image, date)
VALUES
(1, 'John Doe', 'In Progress', 'Inspected the issue, needs further attention.', 'Repaired the faulty component.', 'image001.jpg', '2023-10-28 09:00:00'),
(3, 'Emily Smith', 'Completed', 'Inspection completed, issue resolved.', 'Replaced damaged part.', 'image002.jpg', '2023-10-27 11:30:00'),
(4, 'Michael Johnson', 'Pending', 'Scheduled for inspection.', 'To be inspected.', NULL, '2023-10-29 14:15:00');
    

=== complaint_assignments ===

CREATE TABLE complaint_assignments (
    assignment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role_id INT NOT NULL,
    complaint_id INT NOT NULL,
    assigned_date DATETIME NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (complaint_id) REFERENCES complains(complain_id)
);




=== trigger to insert data to complain assignments ===

DELIMITER //
CREATE TRIGGER InsertComplaintAssignment
AFTER INSERT ON complains
FOR EACH ROW
BEGIN
    INSERT INTO complaint_assignments (role_id, complaint_id, assigned_date)
    VALUES (5, NEW.complain_id, NOW());
END;
//
DELIMITER ;






