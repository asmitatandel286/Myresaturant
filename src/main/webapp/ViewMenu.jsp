
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.List"%>
<%@page import="dto.FoodType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	div{
	display: flex;
	justify-content:space-between;
	align-items:center;
	width: 900px ;
	height: 200px; 
	border: 2px solid red;
	 background-color: geay;
	}
</style>
</head>
<body>
	<%
	List<FoodType> items = (List<FoodType>) request.getAttribute("list");
	%>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Picture</th>
			<th>Type</th>
			<th>Price</th>
			<th>Quntity</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		for (FoodType item : items) {
		%>

		<tr>
			<th><%=item.getId()%></th>
			<th><%=item.getName()%></th>
			<th>
				<%String base64 = Base64.encodeBase64String(item.getPic());%> 
			<img height="100px" width="100px" alt="unknown"
						src="data:image/jpeg;base64,<%=base64%>">
			</th>
			<th><%=item.getType()%></th>
			<th><%=item.getPrice()%></th>
			<th><%=item.getQuantity()%></th>
			<th><a href="edit?id=<%=item.getId()%>"><button>Edit</button></a></th>
			<th><a href="delete?id=<%=item.getId()%>"><button>Delete</button></a></th>
		</tr>
		<%
		}
		%>
	</table>

	<br>
	<br>
	<a href="AdminHomePage.html"><button>Back</button></a>
</body>
</html>