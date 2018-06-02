

CREATE TABLE ReminderDB (id integer primary key AUTOINCREMENT,event varchar(200),date1 varchar(10));

drop table ReminderDB

insert into ReminderDB (event,date1) values('Suhail','22/2/2015');

select * from ReminderDB

update ReminderDB set event='Zu',date1='9' where id=2;
