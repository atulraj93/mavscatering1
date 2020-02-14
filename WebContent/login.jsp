<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
      <div class="logo"><h1><a href="<c:url value='/' />">MAVS Catering System</a></h1></div>
<h2>Login</h2>

<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="LoginForm" action="<c:url value='/LoginController?action=login' />" method="post">
    <table style="width: 1200px; ">

    <tr>
    <td> Username (*): </td>
    <td> <input name="username" value="<c:out value='${User.username}'/>" type="text">  </td>
  	<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" > </td>
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" type="password" value="<c:out value='${User.password}'/>" type="text">  </td>
  	<td> <input name="passwordError"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled"> </td>
    </tr>
    </table>
    <input name="loginBtn" type="submit" value="Login">
	<table>
	<tr>
	<td>New User ? <a href="register.jsp"><span>Register</span></a></td>
	</tr>
	</table>  
    </form>
</td>
</tr>
</table>

</body>
</html>