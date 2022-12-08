<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<style>

	body{background-color: #00b36b;}

</style>
</head>
<body>
<center>
<h1>eLibrary</h1>
<h2>Password Change</h2>
<form action="ForgotServlet" method="post">
<table>
<tr><td>UserName:</td><td><input type="text" name="username"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td><td><center><input type="submit" value="Change">&nbsp;&nbsp;&nbsp;<input type="button" value="Go Back" onclick="history.back()"></center></td></td><td></td></tr><br><br>
</table>
</form>
</center>
</body>
</html>