<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1><marquee>Registration Success</marquee></h1>
<% String name=(String)session.getAttribute("name"); %>
<h2>Hey <%= name %>,you have registered!!</h2>
</body>
</html>