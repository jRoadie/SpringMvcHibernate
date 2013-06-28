<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<table align="center" cellspacing="0" cellpadding="10">
<thead>
	<tr>
		<th>ID</th>
		<th>Code</th>
		<th>Title</th>
		<th>Description</th>
		<th>Start Time</th>
		<th>Duration</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
	<c:if test="${ !empty programs }">
		<c:forEach var="program" items="${ programs }">
		<tr>
			<td>${ program.id }</td>
			<td>${ program.code }</td>
			<td>${ program.title }</td>
			<td>${ program.description }</td>
			<td>${ program.startDateTime }</td>
			<td>${ program.duration }</td>
			<td>${ program.activeStatus }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/program/edit?id=${ program.id }">Edit</a> | 
				<a href="${ pageContext.request.contextPath }/program/delete?id=${ program.id }">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${ empty programs }">
		<tr>
			<td colspan="8">No programs found.</td>
		</tr>
	</c:if>
</tbody>
</table>
<%@include file="footer.jsp" %>