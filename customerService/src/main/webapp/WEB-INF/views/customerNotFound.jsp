<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page session="false" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Not Found</title>
</head>
<body>
<jsp:directive.include file="header.html" />
</br></br>

<h2>Entry Not found.Please go back and try again!</h2>

<center>
		<a class="btn btn-primary" href="/crm/customer/viewCustomer.jsp"
			role="button">Go Back</a>
	</center>
<jsp:directive.include file="footer.html" />
</body>