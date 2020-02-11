<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
    <div class="header_resize">
      <div class="logo"><h1><a href="<c:url value='/userSearchResults.jsp' />">Catering Management Application</a></h1></div>
      <a href="<c:url value='/userController?action=logout' />"><span>Logout</span></a>
      <div class="menu_nav">
      </div>
  </div>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> Username: </td>
    <td> <c:out value="${USER.username}" /> </td>
    </tr>

    <tr>
    <td> Lastname: </td>
    <td> <c:out value="${USER.lastname}"/> </td>
    </tr>
    
    <tr>
    <td> Firstname: </td>
    <td> <c:out value="${USER.firstname}"/> </td>
    </tr>
    
    <tr>
    <td> Role: </td>
    <td> <c:out value="${USER.role}"/> </td>
    </tr>

	<tr>
    <td> UTA ID: </td>
    <td> <c:out value="${USER.utaid}"/> </td>
    </tr>

    <tr>
    <td> Phone: </td>
    <td> <c:out value="${USER.phone}" /> </td>
    </tr>

    <tr>
    <td> Email: </td>
    <td> <c:out value="${USER.email}" /> </td>
    </tr>

	<tr>
    <td> Street Number: </td>
    <td> <c:out value="${USER.streetnumber}"/> </td>
    </tr>
    
    <tr>
    <td> Street Name: </td>
    <td> <c:out value="${USER.streetname}"/> </td>
    </tr>
    
    <tr>
    <td> City: </td>
    <td> <c:out value="${USER.city}"/> </td>
    </tr>
    
    <tr>
    <td> State: </td>
    <td> <c:out value="${USER.state}"/> </td>
    </tr>
    
    <tr>
    <td> Zipcode: </td>
    <td> <c:out value="${USER.zipcode}"/> </td>
    </tr>
    
    <tr>
    </tr>
    </table>
</td>
</tr>
</table>
</body>
</html>