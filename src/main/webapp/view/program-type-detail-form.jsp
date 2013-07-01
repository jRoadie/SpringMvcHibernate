<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@include file="header.jsp" %>
<f:form method="post" commandName="programType" action="${ pageContext.request.contextPath }/program/type/${ formAction }">
	<f:hidden path="id"/>
	<table id="program" border="0" cellspacing="0" >
		<tr>
			<td width="150px"><f:label path="name">Name</f:label></td>
			<td><f:input path="name"/><f:errors path="Name" cssClass="error"/></td>
		</tr>
		<tr>
			<td><f:label path="description">Description</f:label></td>
			<td><f:textarea path="description"/><f:errors path="description" cssClass="error"/></td>
		</tr>
		<tr>
			<td></td>
			<td><f:button type="submit" name="submit">Submit</f:button><f:button type="reset">Reset</f:button> </td>
		</tr>
	</table>
</f:form>
<%@include file="footer.jsp" %>
