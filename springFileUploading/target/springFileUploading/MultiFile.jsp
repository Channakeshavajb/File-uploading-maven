<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multiple File Uploading</title>
</head>
<body>
<form method="post" action="multipleFile"
		enctype="multipart/form-data">
		Enter The File Name:<input type="text" name="fileName"><br>
		Select the File:<input type="file" name="files" /> <br>
		Enter The File Name:<input type="text" name="fileName"><br>
		Select the File:<input type="file" name="files" /> <br>
		Enter The File Name:<input type="text" name="fileName"><br>
		Select the File:<input type="file" name="files" /> <br>
		<input type="submit" value="Upload-File" />
	</form>

</body>
</html>