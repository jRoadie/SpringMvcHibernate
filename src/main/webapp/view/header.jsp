<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TV Programs : jRoadie.com</title>
<style type="text/css">
body{
	font-family: Arial;
	font-size: 14px;
}
#wrap{
	width: 800px;
	margin: 0 auto;
}
#main-nav ul{
	margin: 0 auto;
	padding-left: 0px;
}
#main-nav ul li{
	float: left;
	list-style: none;
	font-size: 14px;
}
#main-nav ul li a{
	color: black;
	padding: 5px 10px;
	text-decoration: none;
}
#main-nav ul li a:hover{
	text-decoration: underline;
}
#notice .success{
	color: green;
	border: 1px solid green;
	padding: 5px 10px;
}
#notice .warning{
	color: orange;
	border: 1px solid orange;
	padding: 5px 10px;
}
#content{
	text-align: left;
}
#content table{
	width: 100%;
	border: 1px solid #aaa;
}
#content td, #content th{
	padding: 5px;
	border: 1px solid #aaa;
}
#content form table{
	border: 0px solid #fff;
}
#content form table td{
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
<div id="notice">${ notice }</div>
</c:if>