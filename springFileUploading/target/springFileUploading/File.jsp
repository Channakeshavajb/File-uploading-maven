<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File uploading</title>
</head>
<body>
	<form method="post" action="fileupload"
		enctype="multipart/form-data">
		Enter The File Name:
		<input type="file" name="file" /> <input type="submit" value="Upload-File" />
	</form>
</body>
</html>