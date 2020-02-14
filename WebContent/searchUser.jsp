<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<body>
      <div class="logo"><h1><a href="<c:url value='/' />">Catering Management Application</a></h1></div>
      <a href="<c:url value='/userController?action=logout' />"><span>Logout</span></a>
      <div class="menu_nav">
  </div>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsgs}'/>" class="errorPane">
<table>
<tr>
	<td>
	<form action="<c:url value='/userController?action=searchUser' />" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> User's Lastname: </td>
 	<td> <input name="lastname" value="<c:out value='${User.lastname}'/>" class="text45">  </td>
  	<td> <input name="lastNameError"  value="<c:out value='${errorMsgs.lastNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" > </td>
	</tr>
</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>
</body>
</html>