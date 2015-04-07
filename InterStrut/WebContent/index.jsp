<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- meta http-equiv="refresh" content="0;URL=TestLogger.action"-->
<title>Insert title here</title>
</head>
<body>
<s:form action="/TestLogger">
	<s:textfield name="name" label="User Name"></s:textfield>
	<s:submit/>
</s:form>
</body>
</html>