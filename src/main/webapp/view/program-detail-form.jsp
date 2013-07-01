<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@include file="header.jsp" %>
<f:form method="post" commandName="program" action="${ pageContext.request.contextPath }/program/${ formAction }">
	<f:hidden path="id"/>
	<table id="program" border="0" cellspacing="0" >
		<tr>
			<td><f:label path="code">Program Code</f:label></td>
			<td><f:input path="code"/><f:errors path="code" cssClass="error"/></td>
		</tr>
		<tr>
			<td><f:label path="title">Title</f:label></td>
			<td><f:input path="title"/><f:errors path="title" cssClass="error"/></td>
		</tr>
		<tr>
			<td><f:label path="description">Description</f:label></td>
			<td><f:textarea path="description"/><f:errors path="description" cssClass="error"/></td>
		</tr>
		<tr>
			<td><f:label path="startDateTime">Date & Time</f:label></td>
			<td><f:input path="startDateTime"/><f:errors path="startDateTime" cssClass="error"/><br/>(dd/mm/yyyy hh:mm)</td>
		</tr>
		<tr>
			<td><f:label path="duration">Duration</f:label></td>
			<td><f:input path="duration"/><f:errors path="duration" cssClass="error"/></td>
		</tr>
		<tr>
			<td><f:label path="activeStatus">Status</f:label></td>
			<td>
				<label><f:radiobutton path="activeStatus" value="1" checked="checked"/>Active</label>
				<label><f:radiobutton path="activeStatus" value="0"/>Inactive</label>
				<f:errors path="activeStatus" cssClass="error"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><f:button type="submit" name="submit">Submit</f:button><f:button type="reset">Reset</f:button> </td>
		</tr>
	</table>
</f:form>
<%@include file="footer.jsp" %>
