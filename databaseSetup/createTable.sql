
//---------event table
create database eventmanagement;
use eventmanagement;

create table event (
   id BIGINT NOT NULL auto_increment,
   title VARCHAR(100) default  NULL,
   description  VARCHAR(200) default NULL,
   fromDate     DATE default NULL,
   toDate     DATE default NULL,
   photoUrl   VARCHAR(200) default NULL,
   request_id BIGINT  NULL,
   isDeleted CHAR(1),
   PRIMARY KEY (id)
);

create table requester (
   id BIGINT NOT NULL auto_increment,
   subject VARCHAR(100) default NULL,
   name  VARCHAR(200) default NULL,
   email   VARCHAR(200) default NULL,
   phone VARCHAR(200) default NULL,
   message VARCHAR(400) default NULL,
   isDeleted CHAR(1),
   PRIMARY KEY (id)
);

create table user (
   id BIGINT NOT NULL auto_increment,
   firstName VARCHAR(100) default NULL,
   lastName VARCHAR(100) default  NULL,
   email VARCHAR(100) default NULL,
   role  VARCHAR(50) default NULL,
   dob     DATE default NULL,
   photoUrl   VARCHAR(200) default NULL,
   request_id BIGINT  NULL,
   isDeleted CHAR(1),
   PRIMARY KEY (id)
);

create table eventUser (
   id BIGINT NOT NULL auto_increment,
   user_id BIGINT  NULL,
   event_id BIGINT  NULL,
   userName VARCHAR(100) default NULL,
   eventTitle VARCHAR(100) default NULL,
   isDeleted CHAR(1),
   FOREIGN KEY (user_id) REFERENCES user(id),
   FOREIGN KEY (event_id) REFERENCES event(id),
   PRIMARY KEY (id)
);
