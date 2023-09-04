<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.FoodType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	FoodType item = (FoodType) request.getAttribute("item");
	%>
	<form method="post" action="update" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label for="id">Id:</label></td>
				<td><input type="number" name="id" id="id" value="<%=item.getId()%>"></td>
			</tr>
			<tr>
				<td><label for="itemname">Name:</label></td>
				<td><input type="text" name="itemname" id="itemname" value="<%=item.getName()%>"></td>
			</tr>
			<tr>
				<td><label for="price">Price:</label></td>
				<td><input type="number" name="price" id="price" value="<%=item.getPrice()%>"></td>
			</tr>
			<tr>
				<td><label for="type">Food Type:</label></td>
				<td>
					<%
					if (item.getType().equals("veg")) {
					%> <input type="radio" name="type" id="veg" value="veg" checked="checked"> <label for="type">veg</label>
						<input type="radio" name="type" id="non-veg" value="non-veg" ><label for="type">non-veg</label> 
					<% } else { %> 
						<input type="radio"name="type" id="veg" value="veg" > <label for="type">veg</label>
						<input type="radio" name="type" id="non-veg" value="non-veg" checked="checked"><label for="type">non-veg</label> 
					<%}%>
				</td>
			</tr>
			<tr>
				<td><label for="quantity">Quantity:</label></td>
				<td><input type="text" name="quantity" id="quantity" value="<%=item.getQuantity()%>"></td>
			</tr>
			<tr>
				<td><label for="picture">Picture:</label></td>
				<td>
					<%
					String base64 = Base64.encodeBase64String(item.getPic());
					%> <img
					height="50px" width="50px" alt="unknown"
					src="data:image/jpeg;base64,<%=base64%>"> <input type="file"
					name="picture" id="picture">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>update</button>
					<button type="reset">cancle</button>

				</td>
			</tr>
		</table>
	</form>
	<a href="viewMenu.jsp"><button>Back</button></a>
</body>
</html>