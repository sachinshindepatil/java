<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eLibrary</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: #333;
  color: white;
   overflow: hidden;
  text-align: center;
}
</style>

<style>
body {
 background-color: #00b36b;
margin:0;
font-family:Arial
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #000;
}

.active {
  background-color: #04AA6D;
  color: white;
}

.topnav .icon {
  display: none;
}


  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
  .topnav.responsive .dropdown {float: none;}
  .topnav.responsive .dropdown-content {position: relative;}
  .topnav.responsive .dropdown .dropbtn {
    display: block;
    width: 100%;
    text-align: left;
  }
  
}
</style>
</head>
<body>
<div class="topnav" id="myTopnav">
  <a href="#home" class="active">Home</a>
  <a href="Register.html">Insert Book Details</a> 
  <a href="Update.html">Update Book Details</a>
	<a href="Display.html">Display</a>
	<a href="Delete.html">Delete Book Details</a>
 <a href="Logout" onclick="return alert('Logout...');">Logout</a>
 
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>
<div style="padding-left:16px">
<center>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h1><b><p style="color:white;">WELCOME TO eLIBRARY</p></b></h1>
</center>
</div>
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>

<div class="footer">
  <p>Copyright &copy; 2030 www.eLibrary.com - All rights are Reserved..</p>
</div>
</body>
</html>