create database if not exists crm_db;
use crm_db;

create table customer (
id int(11) not null auto_increment,
cust_name varchar(128) default null,
email varchar(45) default null,
mobile int(11) default 0,
primary key(id)
);

create table users(
username varchar(50) not null,
password varchar(50) not null,
enabled tinyint(1) not null,
primary key(username)
);

create table authorities(
username varchar(50) not null,
authority varchar(50) not null,
unique key auth_idx (username,authority),
constraint auth_fk foreign key (username) references users (username) 
);

insert into users values
('Admin','{noop}test123',1),
('Guest','{noop}Guest',1);

insert into authorities values 
('Admin', 'GUEST'),
('Admin', 'ADMINISTRATOR'),
('Guest', 'GUEST');

insert into customer values 
(1,'Robb Stark', 'king_in_the_north@winterfell.official.com', 1919191919 ),
(2,'Sansa Stark', 'lady_stark@winterfell.official.com', 1818181818 ),
(3,'John Snow', 'lord_commander@nightswatch.com', 1919191919 ),
(4,'Arya Stark', 'girl_with_no_name@faceless.men.com', 1515151515 ),
(5,'Brandon Stark', 'three_eyed_raven@timselapse.com', 1414141414 ),
(6,'Rickon Stark', 'the_unlucky_stark_kid@dungeon.bolton.com', 1212121212 );