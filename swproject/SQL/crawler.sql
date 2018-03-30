create table crawler (
	c_number int auto_increment,
	c_group varchar(20),
	n_title varchar(300),
	url varchar(500),
	s_content varchar(2000),
	s_user varchar(20),
	c_time datetime not null,
	s_addr varchar(500),
	n_img varchar(5000),
	n_source varchar(50),
	primary key(c_number)
);

alter database swproject character set=utf8mb4 collate utf8mb4_unicode_ci;