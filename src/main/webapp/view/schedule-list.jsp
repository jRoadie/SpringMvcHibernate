<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<table align="center" cellspacing="0" cellpadding="10">
<thead>
	<tr>
		<th>ID</th>
		<th>Program</th>
		<th>Date</th>
		<th>Time</th>
		<th>Duration</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
	<c:if test="${ !empty schedules }">
		<c:forEach var="schedule" items="${ schedules }">
		<tr>
			<td>${ schedule.id }</td>
			<td>${ schedule.program.title }</td>
			<td>${ schedule.date }</td>
			<td>${ schedule.time }</td>
			<td>${ schedule.duration }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/program/schedule/edit?id=${ schedule.id }">Edit</a> | 
				<a href="${ pageContext.request.contextPath }/program/schedule/delete?id=${ schedule.id }">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${ empty schedules }">
		<tr>
			<td colspan="8">No schedules found.</td>
		</tr>
	</c:if>
</tbody>
</table>
<%@include file="footer.jsp" %>