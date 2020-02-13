<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selected Event  </title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/mavs_catering"
        user="root" password="hitesh1312"
    />
     
    <sql:query var="eventsummary"   dataSource="${myDS}">
        SELECT event_ID,lastname,firstname,date,starttime,duration,hallname,est_attendees,eventname
        foodtype,meal,meal_formality,drink_type,ent_items,eventstatus,assign_staff_lname,assign_staff_fname FROM eventsummary;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Event summary</h2></caption>
           
            <c:forEach var="eventsummary" items="${eventsummary.rows}">
                    <tr><td>Event ID:</td>            
                    <td><c:out value="${eventsummary.event_ID}" /></td></tr>
            		
            		<tr><td>Last Name Name:</td>                    
                    <td><c:out value="${eventsummary.lastname}" /></td></tr>
                    
                    <tr><td>Fist Name:</td>                    
                    <td><c:out value="${eventsummary.firstname}" /></td></tr>
                    
                    <tr><td>Event Date:</td>                    
                    <td><c:out value="${eventsummary.date}" /></td></tr>
                    
                    <tr><td>Start time:</td>                    
                    <td><c:out value="${eventsummary.starttime}" /></td></tr>
                    
                    <tr><td>Duration:</td>                    
                    <td><c:out value="${eventsummary.duration}" /></td></tr>                    
                    
                    <tr><td>Hallname:</td>                    
                    <td><c:out value="${eventsummary.hallname}" /></td></tr>
                    
                    
                    <tr><td>Estimated Attendees:</td>
                    <td><c:out value="${eventsummary.est_attendees}" /></td></tr>                    
                    
                    
                    <tr><td>Event Name:</td>                    
                    <td><c:out value="${eventsummary.eventname}" /></td></tr>
                    
                    <tr><td>Food Type:</td>                    
                    <td><c:out value="${eventsummary.food_type}" /></td></tr>                    
                    
                    <tr><td>Meal:</td>                    
                    <td><c:out value="${eventsummary.meal}" /></td></tr>
                    
                    
                    <tr><td>Meal Formality:</td>                    
                    <td><c:out value="${eventsummary.meal_formality}" /></td></tr>                    
                    
                    <tr><td>Drink Type:</td>                    
                    <td><c:out value="${eventsummary.drink_type}" /></td></tr>
                    
                    
                    <tr><td>Entertainment Items:</td>
                    <td><c:out value="${eventsummary.ent_items}" /></td></tr>                    
                    
                    
                    <tr><td>Event Status:</td>                    
                    <td><c:out value="${eventsummary.eventstatus}" /></td></tr>
                    
                    <tr><td>Assigned Staff Lastname:</td>                    
                    <td><c:out value="${eventsummary.assign_staff_lname}" /></td></tr>                    
                    
                    <tr><td>Assigned Staff Firstname::</td>                    
                    <td><c:out value="${eventsummary.assign_staff_fname}" /></td></tr>
                                        
                    
            </c:forEach>
        </table>
          	<td><a href="assignstaff.jsp">assign staff</a></td>
        
    </div>
</body>
</html>