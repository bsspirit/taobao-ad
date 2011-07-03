use sendAD;

CREATE TABLE t_ad_config(
	id int primary key auto_increment,
	nick varchar(32) not null,
	width int not null default 750,
	pic_size int not null default 160,
	enter_show int(11) NOT NULL DEFAULT 1,
  	favor_show int(11) NOT NULL DEFAULT 1,
  	title_show int(11) NOT NULL DEFAULT 1,
  	shoptype int(11) NOT NULL DEFAULT 0,
	create_date timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_ad_user(
	id int primary key auto_increment,
	nick varchar(32) not null unique,
	userid bigint not null unique,
	uid varchar(32) not null unique,
	create_date timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_ad_item(
	id int primary key auto_increment,
	itemid bigint not null unique,
	nick varchar(32) not null,
	title varchar(64) not null,
	price float not null,
	pic_url varchar(256) not null,
	desc_url varchar(256) not null,
	dtime datetime not null,
	create_date timestamp not null default now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_ad_html(
	id int primary key auto_increment,
	uid int not null,
	name varchar(64) not null,
	html text not null,
	create_date datetime not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

