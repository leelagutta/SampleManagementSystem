<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create Customer Page</title>
	<link href="<c:url value="/static/Css/main.css" />" rel="stylesheet" type="text/css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	 <script type="text/javascript">
    	$(document).ready(function() {
    		console.log("${customerModel.error}");
    		var errorMsg = "${customerModel.error}";
        	if((errorMsg).length > 0) { 
                $('#errorMessage').show();
                
            } else {
                $('#errorMessage').hide();
          
    		}
     });
    </script>
</head>
<body>

 <jsp:directive.include file="header.html" />
  </br></br>
	<div class="container">
		<form:form class="form-horizontal" method="POST" commandName="customerModel" >
		  <div class="form-group">
		  <div class="alert alert-danger" role="alert" id ="errorMessage">
		  		${customerModel.error}
		  </div>
		  <%--
		  <h2>
		  	<form:label path="error" cssClass="error" id ="errorMessage" >${customerModel.error}</form:label>
		  </h2>
		  --%>
		 
		  <label for="firstName" class="col-sm-2 control-label">First Name</label>
		    <div class="col-sm-10">
		    	<form:input type="text" class="form-control"  id="firstName" path="firstName" name="firstName"  placeholder="Enter first Name"/>
		    	<form:errors path="firstName" cssClass="error"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lastName" class="col-sm-2 control-label">Last Name</label>
		    <div class="col-sm-10">
		    	<form:input type="text" class="form-control" id="lastName" path="lastName" name="lastName" placeholder="Enter last Name"/>
		    	<form:errors path="lastName" cssClass="error"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
		    	<form:input type="email" class="form-control" id="email" path="email" name="email" placeholder="Enter email"/>
		    	<form:errors path="email" cssClass="error"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="phone" class="col-sm-2 control-label">Phone</label>
		    <div class="col-sm-10">
		    	<form:input type="number" class="form-control" id="phone" path="phone"  name="phone" placeholder="Enter phone"/>
		    	<form:errors path="phone" cssClass="error"/>
		    </div>
		  </div> 
		  <center>
		  	<button type="submit"  class="btn btn-default center">Submit</button>
		  </center>
		  
		</form:form>
	</div>
	  <jsp:directive.include file="footer.html" />
</body>
</html>