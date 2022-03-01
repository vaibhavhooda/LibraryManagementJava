<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
	<h1> Books Page </h1>
	<form action="BookServlet" method="post">
   		<table style="with: 80%">
    		<tr>
    			<td>Book ID:</td>
     			<td><input type="text" name="bookId" /></td>
    		</tr>
    		<tr>
     			<td>Author:</td>
     			<td><input type="text" name="author" /></td>
    		</tr>
    		<tr>
     			<td>Title:</td>
     			<td><input type="text" name="title" /></td>
    		</tr>
    		<tr>
     			<td>Price:</td>
     			<td><input type="text" name="price" /></td>
    		</tr>
    		<tr>
     			<td>Available:</td>
     			<td><label>Yes</label><br></td>
    		</tr>
    		<tr>
     			<td>Member Id:</td>
     			<td><input type="text" name="memberId" /></td>
    		</tr>
    		<tr>
     			<td>Due Date:</td>
     			<td><input type="date" name="dueDate" min="2022-03-01" max="2022-12-31"></td>
    		</tr>
    	</table>
    <input type="submit" name="issue" value="Issue Book">
    <input type="submit" name="update" value="Update Book">
    <input type="submit" name="delete" value="Delete Book">
  </form>
</body>
</html>