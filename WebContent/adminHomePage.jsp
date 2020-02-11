<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Catering Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">

      <div class="logo"><h1><a href="<c:url value='/' />">Catering Management Application</a></h1></div>
  <div class="content">  

      <div class="menu_nav">
        <ul>
          <li><a href="<c:url value='/searchUser.jsp' />"><span>Search for User</span></a></li>
          <li><a href="<c:url value='/userController?action=viewProfile' />"><span>View/Modify My Profile</span></a></li>  
        </ul>
      </div>
    </div>
  </div>
  </div>
  </div>  
</body>
</html>