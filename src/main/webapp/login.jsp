<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
body{
	background-color: #00b36b;
}

}
</style>
</head>
<body>
<center>
<h1>eLibrary</h1>
<h2>Login</h2>
<form action="login" method="post">
<table>
<tr><td>UserName:</td><td><input type="text" name="username"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td><td><center><input type="submit" value="Login" onclick="return alert('Login...');">&nbsp;&nbsp;&nbsp;<input type="button" value="Go Back" onclick="history.back()"></center></td></td><td></td></tr><br><br>
<tr><td><td><center><a href="Forgot.jsp">Forgot Password?</a></center><br></td></td></tr>
<tr><td><td><center><input type="button" onclick="location.href='signUp.jsp';" value="Sign Up" /></center><br></td></td></tr>

</table>
</form>
</center>

</body>
</html>