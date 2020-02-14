<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Staff</title>
</head>
<body>
<div class="logo"><h1><a href="<c:url value='/eventsummary.jsp' />">Mavs Catering System</a></h1></div>
<a href="<c:url value='/userController?action=logout' />"><span>Logout</span></a>
<h2>Assign Staff</h2>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="assignstaff" action="<c:url value='/eventController?action=assignStaff' />" method="post">
    <table style="width: 1200px; ">
    
    
    <tr>
    <td> First Name (*): </td>
    <td> <input name="firstname" type="text">  </td>
  	<td> <input name="firstNameError"  value="<c:out value='${errorMsgs.staffError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" > </td>
    </tr>
    
    <tr>
    <td> Last Name (*): </td>
    <td> <input name="lastname" type="text" >  </td>
    </tr>
  
    </table>
    <input type="submit" value="Submit">
    </form>
</td>
</tr>
</table>
</body>
</html>