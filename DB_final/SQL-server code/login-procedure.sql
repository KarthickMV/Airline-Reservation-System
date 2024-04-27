Alter PROCEDURE dbo.uspLogin
    @pLoginName NVARCHAR(254),
    @pPassword NVARCHAR(50),
    @responseMessage NVARCHAR(250)='' OUTPUT
AS
BEGIN

    SET NOCOUNT ON

    DECLARE @userID varchar

    IF EXISTS (SELECT TOP 1 [email_id] FROM [dbo].[user_details] WHERE [user_name]=@pLoginName)
    BEGIN
        SET @userID=(SELECT [email_id] FROM [dbo].[user_details] WHERE [user_name]=@pLoginName AND [@pPassword]=HASHBYTES('SHA1', @ppassword))

       IF(@userID IS NULL)
           SET @responseMessage='Incorrect password'
       ELSE 
           SET @responseMessage='User successfully logged in'
    END
    ELSE
       SET @responseMessage='Invalid login'

END
go

DECLARE @responseMessage NVARCHAR(250) 
EXEC	dbo.uspLogin
		@pLoginName = N'himshuffkla',
		@pPassword = N'694321',
		@responseMessage = @responseMessage OUTPUT

SELECT	@responseMessage as N'@responseMessage'


select * from dbo.user_details;