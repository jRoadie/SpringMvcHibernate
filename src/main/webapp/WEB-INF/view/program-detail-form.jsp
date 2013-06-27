<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<f:form method="post" commandName="program" action="${ pageContext.request.contextPath }/program/edit">
	<f:hidden path="id"/>
	<f:input path="code"/>
	<f:input path="title"/>
	<f:textarea path="description"/>
	<label><f:radiobutton path="activeStatus" value="1" checked="checked"/>Active</label>
	<label><f:radiobutton path="activeStatus" value="0"/>Inactive</label>
	<f:button type="submit" name="submit">Submit</f:button>
</f:form>
