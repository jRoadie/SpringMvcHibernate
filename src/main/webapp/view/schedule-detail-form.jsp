<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@include file="header.jsp" %>
<f:form method="post" commandName="schedule" action="${ pageContext.request.contextPath }/program/schedule/${ formAction }">
	<f:hidden path="id"/>
	<table id="schedule" border="0" cellspacing="0" >
		<tr>
			<td width="150px"><f:label path="program">Program</f:label></td>
			<td>
				<f:select path="program.id">
					<f:options items="${ programs }" itemValue="id" itemLabel="title" />
				</f:select>
			</td>
		</tr>
		<tr>
			<td><f:label path="date">Date</f:label></td>
			<td><f:input path="date"/><br/>( dd/mm/yyyy )</td>
		</tr>
		<tr>
			<td><f:label path="time">Time</f:label></td>
			<td><f:input path="time"/><br/>( HH:mm )</td>
		</tr>
		<tr>
			<td><f:label path="duration">Duration</f:label></td>
			<td><f:input path="duration"/></td>
		</tr>
		<tr>
			<td></td>
			<td><f:button type="submit" name="submit">Submit</f:button><f:button type="reset">Reset</f:button> </td>
		</tr>
	</table>
</f:form>
<%@include file="footer.jsp" %>
