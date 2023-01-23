CREATE TABLE StockManagementAccount(
	id serial,
	name varchar(64) not null,
	mail varchar(256) not null unique,
	salt varchar(32) not null,
	password varchar(64) not null,
	primary key(id)
);

CREATE TABLE Stock (
	id serial,
	StockId varchar(64) not null,
	StockName varchar(128) not null,
	StockCategory varchar(128) not null,
	StockPrice int not null,
	StockNote text,
	created_at timestamp,
	primary key(id)
);