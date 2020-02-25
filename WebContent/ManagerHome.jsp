<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Home Page</title>
</head>
<body >
<div class="logo"><h1><a href="<c:url value='/' />">Campus Event Catering System</a></h1></div>
<a href="<c:url value='/userController?action=logout' />"><span>Logout</span></a>
<h1>Manager Home page</h1>
  <ul>
  	<li><a href="<c:url value='/eventController?action=eventsummary' />">View Caterer Event Summary</a></li>
  	<li><a href="<c:url value='/eventController?action=eventsummary' />">Update Profile</a></li>
  </ul>
</body>
</html>