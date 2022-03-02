<%@ page language="java" import="java.util.*, java.lang.*, model.Borrow" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Borrow Book List</h2>
	<table border="1" cellpadding="2" cellspacing="2">
	   <tr>
	   		 <th>Sl. No.</th>
		     <th>Book Name</th>
		     <th>Author Name</th>
		     <th>Member Name</th>
		     <th>Issue Date</th>
		     <th>Due Date</th>
		     <th>Return Date</th>
	    </tr>
	    <% 
	    	ArrayList<Borrow> list = (ArrayList<Borrow>) request.getAttribute("borrow"); 
	    	if(list != null){
	    	
		    	Borrow borrow = new Borrow();
		     	for (int i=0; i < list.size(); i++) {
		     		borrow = list.get(i);
	     	
        %>

	            <tr>
	            	<td><%=i+1%></td>
	                <td><%=borrow.getBook_name()%></td>
	                <td><%=borrow.getAuthor_name()%></td>
	                <td><%=borrow.getMember_name()%></td>
	                <td><%=borrow.getIssue_date()%></td>
	                <td><%=borrow.getDue_date()%></td>
	                <td><%=borrow.getReturn_date()%></td>
	            </tr>
            <%
	     		};
            }
	    	else{
	    	%>
	    		<tr align="center">
	    			<td colspan=6>Data not Found!!!!!!</td>
	    		</tr>
	    	<%
	    	};
            %> 
	</table>
</body>
</html>