<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TV Programs : jRoadie.com</title>
<link type="text/css" rel="stylesheet" media="screen" href='<c:url value="/resources/style/basic.css" />' />
<script type="text/javascript" src='<c:url value="/resources/script/basic.js"/>'></script>
</head>
<body>
<div id="wrap">
<div id="header">
	<h1><img src='<c:url value="/resources/style/img/tv.png"/>' alt="TV Icon" style="position: relative; top: 5px;" /> TV Programs App</h1>
	<p>SpringMVC and Hibernate Example by jRoadie</p>
	<%@ include file="navigation.jsp" %>
</div>
<div id="content">
<h3>${ pageTitle }</h3>
<c:if test="${ !empty notice }">
	<p id="notice" class="success">${ notice }</p>
</c:if>