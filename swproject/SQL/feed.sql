create table feed(
	id varchar(20) not null,
	f_number int not null auto_increment,
	myfeed varchar(1000),
	f_time datetime,
	f_group varchar(20),
	primary key(f_number),
	foreign key(id) references user(id)
);