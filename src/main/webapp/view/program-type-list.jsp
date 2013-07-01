<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<table align="center" cellspacing="0" cellpadding="10">
<thead>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
	<c:if test="${ !empty programTypes }">
		<c:forEach var="programType" items="${ programTypes }">
		<tr>
			<td>${ programType.id }</td>
			<td>${ programType.name }</td>
			<td>${ programType.description }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/program/type/edit?id=${ programType.id }">Edit</a> | 
				<a href="${ pageContext.request.contextPath }/program/type/delete?id=${ programType.id }">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${ empty programTypes }">
		<tr>
			<td colspan="8">No program types found.</td>
		</tr>
	</c:if>
</tbody>
</table>
<%@include file="footer.jsp" %>