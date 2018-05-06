use SPM
create table module
(
module_id int identity(1,1),
module char(10) not null,
primary key (module_id)
)
create table building
(
building_id int identity(1,1),
building char(10) not null,
primary key (building_id)
)
create table room
(
room_id int identity(1,1),
room char(10) not null,
primary key (room_id)
)
create table day
(
day_id int identity(1,1),
day char(10) not null,
primary key (day_id)
)
create table time
(
time_id int identity(1,1),
time char(10) not null,
primary key (time_id)
)
create table article
(
article_id int identity(1,1),
title varchar(50) not null,
module_id int not null,
add_time datetime not null,
detail varchar(MAX) not null,
primary key (article_id),
foreign key (module_id) references module (module_id)
)
create table studentUser
(
student_id char(10),
password char(10) not null,
primary key (student_id)
)
create table student
(
student_id char(10),
student_name char(10),
sex char(10),
age int,
sdept char(20),
primary key (student_id),
foreign key (student_id) references studentUser (student_id)
)
create table teacherTemp
(
teacher_id char(10),
password char(10) not null,
teacher_name char(10) not null,
primary key (teacher_id)
)
create table teacherUser
(
teacher_id char(10),
password char(10) not null,
primary key (teacher_id)
)
create table teacher
(
teacher_id char(10),
teacher_name char(10) not null,
sex char(10),
age int,
primary key (teacher_id),
foreign key (teacher_id) references teacherUser (teacher_id)
)
create table course
(
course_id int identity(1,1),
course_name char(10) not null,
teacher_id char(10) not null,
building_id int not null,
room_id int not null,
day_id int not null,
time_id int not null,
primary key (course_id),
foreign key (teacher_id) references teacherUser (teacher_id),
foreign key (building_id) references building (building_id),
foreign key (room_id) references room (room_id),
foreign key (day_id) references day (day_id),
foreign key (time_id) references time (time_id)
)
create table takeTemp
(
course_id int,
student_id char(10),
primary key (course_id,student_id),
foreign key (course_id) references course (course_id),
foreign key (student_id) references studentUser (student_id)
)
create table take
(
course_id int,
student_id char(10),
grade float not null,
primary key (course_id,student_id),
foreign key (course_id) references course (course_id),
foreign key (student_id) references studentUser (student_id)
)

insert into module(module) values('课程介绍')
insert into module(module) values('课程内容')
insert into module(module) values('课程实践')
insert into module(module) values('教学团队')
insert into building(building) values('一教')
insert into building(building) values('二教')
insert into building(building) values('三教')
insert into building(building) values('四教')
insert into room(room) values('101')
insert into room(room) values('102')
insert into room(room) values('201')
insert into room(room) values('202')
insert into day(day) values('周一')
insert into day(day) values('周二')
insert into day(day) values('周三')
insert into day(day) values('周四')
insert into day(day) values('周五')
insert into day(day) values('周六')
insert into day(day) values('周日')
insert into time(time) values('1,2节')
insert into time(time) values('3,4节')
insert into time(time) values('3,4,5节')
insert into time(time) values('6,7节')
insert into time(time) values('8,9节')
insert into time(time) values('10,11,12节')