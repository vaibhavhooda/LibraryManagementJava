<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1> Member Page </h1>
<!--call the ServletClassname as StudentServlet.java --> 

 <form action="MemberServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Member Name</td>
     <td><input type="text" name="memName" /></td>
    </tr>
    <tr>
     <td>Member Id</td>
     <td><input type="text" name="memId" /></td>
    </tr>
    <tr>
     <td>Member Address</td>
     <td><input type="text" name="memAddress" /></td>
    </tr>
    <tr>
     <td>Member Type</td>
     <td><input type="text" name="memType" /></td>
    </tr>
    <tr>
     <td>Membership Start date</td>
     <td><input type="text" name="memStartdate" /></td>
    </tr>
    <tr>
     <td>Membership Expiry date</td>
     <td><input type="text" name="memExpirydate" /></td>
    </tr>
    </table>
    <input type="submit" name="register" value="Register Member">
    <input type="submit" name="update" value="Update Member">
  </form>
    
   
  
</body>
</html>