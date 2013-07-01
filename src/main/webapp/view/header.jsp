<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TV Programs : jRoadie.com</title>
<style type="text/css">
body{
	text-align: center;
}
#wrap{
	width: 600px;
	margin: 0 auto;
}
#main-nav ul{
	width: 400px;
	margin: 0 auto;
}
#main-nav ul li{
	float: left;
	list-style: none;
	font-size: 18px;
	margin-left: 30px;
}
#main-nav ul li a{
	color: black;
	text-decoration: none;
}
.success{
	color: green;
}
#content{
	text-align: left;
}
#content table{
	border: 1px solid #aaa;
}
#content td, #content th{
	padding: 5px;
	border: 1px solid #aaa;
}
#content table#program{
	border: 0px solid #fff;
}
#content table#program td{
	border: 0px solid #fff;
}
form .error{
	color: red;
}
</style>
</head>
<body>
<div id="wrap">
<div id="header">
	<h1>TV Programs App</h1>
	<p>SpringMVC and Hibernate Example by jRoadie</p>
	<%@ include file="navigation.jsp" %>
</div>
<div id="content">
<h3>${ pageTitle }</h3>
<c:if test="${ !empty notice }">
	<p id="notice" class="success">${ notice }</p>
</c:if>