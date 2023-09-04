<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.List"%>
<%@page import="dto.Customer"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<Customer> cus=(List<Customer>)request.getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Pass</th>
			<th>Dob</th>
			<th>Gender</th>
			<th>Country</th>
			<th>Age</th>
			<th>Pic</th>
			<th>Delete</th>
		</tr>
		
			<% for(Customer c : cus){ %>
			<tr>
			<th><%=c.getId()%></th>
			<th><%=c.getName()%></th>
			<th><%=c.getEmail()%></th>
			<th><%=c.getPhone()%></th>
			<th><%=c.getPass()%></th>
			<th><%=c.getDob()%></th>
			<th><%=c.getGender()%></th>
			<th><%=c.getCountry()%></th>
			<th><%=c.getAge()%></th>
			<th>
				<%String base64 = Base64.encodeBase64String(c.getPic());%> 
				<img height="100px" width="100px" alt="unknown"src="data:image/jpeg;base64,<%=base64%>">
			</th>
			<th><a href="deletecus?id=<%=c.getId()%>"><button>Delete</button></a></th>
		</tr>	
			<%} %>
		
	</table>
</body>
</html>