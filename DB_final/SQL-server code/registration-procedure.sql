alter procedure dbo.uspAddUser
 @pfirst_name nvarchar(50),
 @plast_name nvarchar(50),
 @pgender nchar(1),
 @pemail_id nvarchar(50),
 @puser_name nvarchar(50),
 @ppassword nvarchar(30),
 @pphone_no nvarchar(50),
 @responseMessage NVARCHAR(250)='' OUTPUT
as
 begin 
  
   begin try
     insert into [dbo].[user_details] ([first_name], [last_name], [gender], [email_id], [user_name], [passwod], [phone_no])
	 values
	 (@pfirst_name, @plast_name, @pgender, @pemail_id, @puser_name, HASHBYTES('SHA1', @ppassword), @pphone_no)

	 set @responseMessage = 'Success'

	end try

	begin catch
		set @responseMessage='Already Registered!'
	end catch
end
go

DECLARE @responseMessage NVARCHAR(250)
exec dbo.uspAddUser
@pfirst_name = N'Himanshu',
@plast_name = N'Shukla',
@pgender = N'M',
@pemail_id = N'himshukla007@gmail.com',
@puser_name = N'himshukla',
@ppassword = N'654321',
@pphone_no = N'7895290510',
@responseMessage = @responseMessage OUTPUT
go

SELECT	@responseMessage as N'@responseMessage'

SELECT @@ROWCOUNT;
go

select * from dbo.user_details;
go


TRUNCATE TABLE dbo.user_details