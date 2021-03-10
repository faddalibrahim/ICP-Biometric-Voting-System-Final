drop database if exists election;

create database election;
use election;


create table voters(
	id bigint unsigned,
    polling_station_code char(7) NOT NULL,
    name varchar(50) NOT NULL,
    gender enum('male','female') NOT NULL,
    dob date,
    has_voted boolean DEFAULT 0,
    PRIMARY KEY (id)
);

insert into voters values(4354011192,"C090904","Faddal Ibrahim","male","2000-06-13",0),
						 (4354011193,"C090904","Excel Chukwu","female","2000-06-13",1),
                         (4354011194,"C090904","Kenneth Ofori","male","2000-06-13",0);
                         
                         
create table candidates(
	id bigint unsigned,
    name varchar(50) NOT NULL,
    gender enum('male','female') NOT NULL,
    dob date,
    party varchar(50) not null,
    votes int,
    PRIMARY KEY (id)
);

insert into candidates values(1232021,"John Dramani Mahama","male","2000-06-13","NDC",0),
							 (1232022,"Nana Addo-Danquah Akuffo Addo","male","2000-06-13","NPP",0),
                             (1232023,"Nana Konadu Agyeman-Rawlings","female","2000-06-13","NDP",0),
                             (1232024,"Excel Chukwu","male","2000-06-13","PNC",0)