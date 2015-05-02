<%@page import="com.dataart.risingsun.app.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		body {
			background-color: #336600;
		}
		#login-box-admin {
			text-align: center;
		}
	</style>
	<title>Admin panel</title>
</head>
<body>
	<div id="login-box-admin">
		<form action="<%=Constants.HOME %>/LoginAdmin">
			<label for="login">Login</label><br>
			<input type="text" name="login" maxlength="<%=Constants.MAX_LOGIN_LENGTH %>"/><br>
			<label for="password">Password</label><br>
			<input type="password" name="password" <%=Constants.MAX_PASSWORD_LENGTH %>/><br>
			<input type="submit" value="Login" /><br>
		</form>
	</div>
</body>
</html>
