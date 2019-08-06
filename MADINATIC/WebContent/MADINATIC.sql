
drop database if exists Madinatic;
CREATE DATABASE IF NOT EXISTS Madinatic;

USE Madinatic;
CREATE TABLE IF NOT EXISTS Acount(
	username varchar(15) primary key,
    passeword varchar(20),
    date_create date
);
Create table if not exists Admins (
	id_card integer,
	username varchar(15),
    foreign key(username)
		references Acount(username)
        on update cascade on delete cascade
);


create table if not exists Wilaya(
	id_wilaya integer auto_increment primary key,
    name_ varchar(20)
);
create table if not exists Town(
	id_town integer primary key auto_increment,
    name_ varchar(20),
    id_wilaya integer,
    foreign key(id_wilaya)
		references Wilaya(id_wilaya)
);

CREATE TABLE IF NOT EXISTS Citizen(
	id_card integer PRIMARY KEY ,
    name_ varchar(20),
    first_name varchar(20),
	address varchar(20),
    email varchar(20),
    phone_number varchar(20),
    username varchar(15) ,
	FOREIGN KEY (username)
        REFERENCES Acount(username)
        ON UPDATE CASCADE ON DELETE CASCADE,
	id_town integer ,
    foreign key(id_town) references Town(id_town)
);


CREATE TABLE IF NOT EXISTS Supervisor(
	id_sup int primary key auto_increment,
    id_town integer,
    username varchar(15) ,
	FOREIGN KEY (username)
        REFERENCES Acount (username)
        ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key(id_town)
		references Town(id_town)
        
);

CREATE TABLE IF NOT EXISTS Service(
	id_service integer auto_increment primary key ,
	service_name varchar(15),
    type_service enum ('INTERN','EXTERN'),
    email varchar(20),
    siteweb varchar(20),
    username varchar(15),
    id_town integer,
    foreign key(id_town)
		references Town(id_town),
	foreign key (username)
		references Acount(username) ON delete cascade on update cascade
);							

Create table if not exists Employee(
		id_employee int primary key auto_increment,
        firstname varchar(20),
        name_ varchar(20),
        phone_number varchar(10),
        type_emp enum('SERVICE_AGENT','SUPERVISOR'),
        id_card integer,
        date_begin date,
        date_end date,
        id_sup integer,
        id_service integer,
        foreign key(id_sup) references Supervisor(id_sup),
        foreign key(id_service) references Service(id_service)
 );	
	
create table if not exists TypeDeclaration(
	id_type integer primary key auto_increment,
    name_ varchar(35)
);
    
create table if not exists Declaration(
	id_dec integer primary key auto_increment,
    declaration_state enum('NEW','ORIENTED','REPORTEDB','WORKING','REPORTEDE','FINISHED','INCOMPLET'),
    declaration_type integer,
    is_published boolean,
    description_ varchar(650),
    date_create date,
    id_sup integer,
    id_citizen integer ,
    foreign key(id_sup)
		references Supervisor(id_sup),
	foreign key(id_citizen)
		references Citizen(id_card),
	foreign key(declaration_type)
		references TypeDeclaration(id_type)
);
create table if not exists ReportBegin(
	id_report integer primary key auto_increment,
    description varchar(650),
    date_create date,
    date_begin date,
    date_end date
);
create table if not exists ReportEnd(
	id_report integer primary key auto_increment,
    description varchar(650),
    date_create date
);

create table if not exists Treatement(
	id integer auto_increment primary key,
	id_declaration integer ,
    id_service integer,
    id_reportB integer,
    id_reportE integer,
    foreign key (id_declaration)
		references Declaration(id_dec), 
	foreign key (id_service)
		references Service(id_service),
	foreign key (id_reportB)
		references ReportBegin(id_report),
	foreign key (id_reportE)
		references ReportEnd(id_report)
	
);

create table if not exists Announce(
	id_announce integer auto_increment primary key,
    description varchar(650),
    is_published boolean,
    type_announce enum('NEW','EVENT'),
    date_begin date ,
    date_end date,
    id_sup integer,
    id_service integer,
    foreign key(id_sup)
		references Supervisor(id_sup),
	foreign key(id_service)
		references Service(id_service)
);

create table if not exists AttachedPiece(
	id_piece integer primary key auto_increment,
    piece blob,
    id_dec integer,
    id_report integer,
    id_announce integer,
    foreign key(id_dec)
		references Declaration(id_dec) ,
	foreign key(id_report)
		references ReportEnd(id_report)	,
	foreign key(id_announce)
		references Announce(id_announce)
);