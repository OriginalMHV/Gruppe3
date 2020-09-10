

CREATE USER ‘mhv’@'%' IDENTIFIED BY ‘mariadb’;
DROP DATABASE IF EXISTS otra;
CREATE DATABASE otra;
GRANT ALL PRIVILEGES ON otra.* TO 'Michael'@%;
USE otra;




create table if not EXISTS otra.user
(
    User_id integer UNIQUE auto_increment,
    User_firstName varchar(255),
    User_lastName varchar(255),
    User_Email varchar(255),
    User_password varchar(255),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_id)
);

insert into otra.user (User_firstName, User_lastName, User_Email, User_password) values ('Michael','Herland Valen','michaelherlandvalen@hotmail.no','mariadb')