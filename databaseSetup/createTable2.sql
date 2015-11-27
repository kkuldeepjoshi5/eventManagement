create table event (
   id bigserial NOT NULL ,
   title character(100) default  NULL,
   description  character(200) default NULL,
   fromDate     DATE default NULL,
   toDate     DATE default NULL,
   photoUrl   character(200) default NULL,
   request_id BIGINT  NULL,
   isDeleted character(1),
   CONSTRAINT eventId PRIMARY KEY (id)
);

create table requester (
   id bigserial NOT NULL,
   subject CHARACTER(100) default NULL,
   name  CHARACTER(200) default NULL,
   email   CHARACTER(200) default NULL,
   phone CHARACTER(200) default NULL,
   message CHARACTER(400) default NULL,
   isDeleted CHARACTER(1),
   CONSTRAINT requesterId PRIMARY KEY (id)
);

create table users(
   id bigserial NOT NULL ,
   firstName CHARACTER(100) default NULL,
   lastName CHARACTER(100) default  NULL,
   email CHARACTER(100) default NULL,
   role  CHARACTER(50) default NULL,
   dob     DATE default NULL,
   photoUrl   CHARACTER(200) default NULL,
   request_id BIGINT  NULL,
   isDeleted CHAR(1),
   CONSTRAINT usersId  PRIMARY KEY (id)
);

create table eventUser (
   id bigserial NOT NULL ,
   user_id BIGINT  NULL,
   event_id BIGINT  NULL,
   userName CHARACTER(100) default NULL,
   eventTitle CHARACTER(100) default NULL,
   role CHARACTER(50) default NULL,
   isDeleted CHAR(1),
   CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users(id),
   CONSTRAINT event_id FOREIGN KEY (event_id) REFERENCES event(id),
   CONSTRAINT userEventId PRIMARY KEY (id)
);
