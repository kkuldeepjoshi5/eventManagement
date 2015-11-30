create table event (
   id BIGINT NOT NULL ,
   title character(100) default  NULL,
   description  character(200) default NULL,
   fromDate     DATE default NULL,
   toDate     DATE default NULL,
   photoUrl   character(200) default NULL,
   request_id BIGINT  NULL,
   isDeleted character(1),
   PRIMARY KEY (id)
);

