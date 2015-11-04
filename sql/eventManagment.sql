
  
 DELIMITER //
CREATE PROCEDURE  insertEvent(IN event_title VARCHAR(30),IN event_description TEXT,IN event_Edate VARCHAR(30),IN event_photo TEXT,IN event_dir VARCHAR(50))
BEGIN
 INSERT INTO event(title,description,Edate,photo,dir)
 VALUES(event_title,event_description,event_Edate,event_photo,event_dir);
  END// 
  DELIMITER ; 
  
    DELIMITER //
CREATE PROCEDURE getAllEvent()
BEGIN
SELECT *
FROM event;
  END//
  DELIMITER ;
  
   DELIMITER //
CREATE PROCEDURE  deleteEvent(IN userId INT)
BEGIN
DELETE 
FROM user
WHERE user_id=userId;	
  END// 
  DELIMITER ; 
  
    DELIMITER //
CREATE PROCEDURE  updateEvent(IN userId INT,IN name VARCHAR(30),IN email VARCHAR(30))
BEGIN
UPDATE user 
SET user_name=name, user_email=email
WHERE user_id=userId ;	
  END// 
  DELIMITER ; 
  

  