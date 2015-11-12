insert into event(title,description,fromDate,toDate,photoUrl,request_id,isDeleted) values('raman birthDay','birsth day party','2016-01-13','2016-01-15','/kuldeep.jpg',1,'N'); 
insert into event(title,description,fromDate,toDate,photoUrl,request_id,isDeleted) values('brothers marriage','marriage party','2016-02-13','2016-02-25','/marriage.jpg',2,'N'); 

insert into requester(subject,name,email,phone,message,isDeleted) values('raman birth day','raghu','kkuldeepjoshi5@gmail.com','9413640466','hi please arrange this party','N'); 
insert into requester(subject,name,email,phone,message,isDeleted) values('brothers marriage','test','testMail@gmail.com','9414617081','hi contact at once as we decssed early','N'); 

insert into user(firstName,lastName,email,role,dob,photoUrl,request_id,isDeleted) values('kuldeep','joshi','kkuldeepjoshi5@gmail','ADMIN','1992-01-19','/kuldeepjoshi.jpg',null,'N'); 
insert into user(firstName,lastName,email,role,dob,photoUrl,request_id,isDeleted) values('raghu','birla','raghu.birla@gmail','CUSTOMER','1993-02-10','/raghu.jpg',1,'N'); 
insert into user(firstName,lastName,email,role,dob,photoUrl,request_id,isDeleted) values('salagram','sharma','sharma.salagram1@gmail','MANAGER','1990-06-07','/salag.jpg',null,'N')
insert into eventUser(user_id,event_id,userName,eventTitle,isDeleted) values(3,1,'salagram sharma','raman birthDay','N'); 
insert into eventUser(user_id,event_id,userName,eventTitle,isDeleted) values(2,1,'raghu birla','raman birthDay','N'); 
insert into eventUser(user_id,event_id,userName,eventTitle,isDeleted) values(1,1,'kuldeep joshi','raman birthDay','N'); 
insert into eventUser(user_id,event_id,userName,eventTitle,isDeleted) values(3,2,'salagram sharma','brothers marriage','N'); 
insert into eventUser(user_id,event_id,userName,eventTitle,isDeleted) values(1,2,'kuldeep joshi','brothers marriage','N'); 


//--- delete from event where id='1'
