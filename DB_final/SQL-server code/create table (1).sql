create table user_details (
	user_id int identity(1,1) not null Primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	gender varchar(50) not null,
	email_id varchar(50) not null unique,
	user_name varchar(50) not null unique,
	password varchar(30) not null,
	phone_no varchar(100) not null unique,
	user_role varchar(50) default 'user'
)

SET IDENTITY_INSERT dbo.user_details ON;  
GO 

--Alter table dbo.user_details 
--drop column user_role;

--alter table dbo.user_details
--add user_role binary default 1;

--select * from [Airlines-Booking-System].dbo.user_details
--insert into dbo.user_details (
--	user_id,
--	user_name,
--	first_name,
--	middle_name,
--	last_name,
--	email_id,
--	password,
--	gender, mobile_no, address
--)
--values
--( 'himshukla',
--	'Himanshu',
--	 '--',
--	 'Shukla',
--	 'himshukla007@gmail.com',
--	 PWDENCRYPT('hello!'),
--	 'm', 7895290410, 'Mathura'
--	 )


--PWDENCRYPT ( 'password' )  

--SELECT name FROM sys.sql_logins   
--WHERE PWDCOMPARE('password', password_hash) = 1 