<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Member"%>
<!DOCTYPE html>
<html>
<head>
<style>
table#list th {
  border:1px solid black;
}

table#list {
	border-spacing: 30px;
}
</style>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<% 
     ArrayList rows = new ArrayList();

     if (request.getSession().getAttribute("memberList") != null) {
         rows = (ArrayList) request.getAttribute("memberList");
     }
%>

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
  </form><br><br>
    
  <form action="MemberServlet" method="get">
    <table id="list" style="with: 80%; ">
	    <tr>
	     <th>Member Name</th>
	     <th>Member Id</th>
	     <th>Member Address</th>
	     <th>Member Type</th>
	     <th>Membership Start date</th>
	     <th>Membership Expiry date</th>
	    </tr>
	    
	    <% for (int i = 0; i < rows.size(); i++) { %>
	    <tr>  
	    	<% Member mmbr = (Member) rows.get(0); %>
	    	<td>
	    		<%= mmbr.getMem_id() %>
	    	</td>
	    	<td><%= mmbr.getMem_name() %></td>
	    	<td><%= mmbr.getMem_address() %></td>
	    	<td><%= mmbr.getMem_type() %></td>
	    	<td><%= mmbr.getMem_date() %></td>
	    	<td><%= mmbr.getExpiry_date() %></td>
        </tr>
        <%} %>
    </table>
   </form>
   
  
</body>
</html>