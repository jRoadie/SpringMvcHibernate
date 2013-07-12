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
	<c:if test="${ !empty categories }">
		<c:forEach var="category" items="${ categories }">
		<tr>
			<td>${ category.id }</td>
			<td>${ category.name }</td>
			<td>${ category.description }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/program/category/edit?id=${ category.id }">Edit</a> | 
				<a href="${ pageContext.request.contextPath }/program/category/delete?id=${ category.id }">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${ empty categories }">
		<tr>
			<td colspan="8">No categories found.</td>
		</tr>
	</c:if>
</tbody>
</table>
<%@include file="footer.jsp" %>