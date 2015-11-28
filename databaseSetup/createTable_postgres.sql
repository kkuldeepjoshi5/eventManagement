CREATE TABLE event
(
  id bigserial NOT NULL,
  title character(100) DEFAULT NULL::bpchar,
  description character(200) DEFAULT NULL::bpchar,
  fromdate date,
  todate date,
  photourl character(200) DEFAULT NULL::bpchar,
  request_id bigint,
  isdeleted boolean,
  CONSTRAINT eventid PRIMARY KEY (id)
);

CREATE TABLE eventuser
(
  id bigserial NOT NULL,
  user_id bigint,
  event_id bigint,
  username character(100) DEFAULT NULL::bpchar,
  eventtitle character(100) DEFAULT NULL::bpchar,
  role character(50) DEFAULT NULL::bpchar,
  isdeleted boolean,
  CONSTRAINT usereventid PRIMARY KEY (id),
  CONSTRAINT event_id FOREIGN KEY (event_id)
      REFERENCES event (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE requester
(
  id bigserial NOT NULL,
  subject character(100) DEFAULT NULL::bpchar,
  name character(200) DEFAULT NULL::bpchar,
  email character(200) DEFAULT NULL::bpchar,
  phone character(200) DEFAULT NULL::bpchar,
  message character(400) DEFAULT NULL::bpchar,
  isdeleted boolean,
  CONSTRAINT requesterid PRIMARY KEY (id)
);

CREATE TABLE users
(
  id bigserial NOT NULL,
  firstname character(100) DEFAULT NULL::bpchar,
  lastname character(100) DEFAULT NULL::bpchar,
  email character(100) DEFAULT NULL::bpchar,
  role character(50) DEFAULT NULL::bpchar,
  dob date,
  photourl character(200) DEFAULT NULL::bpchar,
  request_id bigint,
  isdeleted boolean,
  CONSTRAINT usersid PRIMARY KEY (id)
);

