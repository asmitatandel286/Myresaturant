<%@page import="java.time.LocalDate"%>
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
			System.out.println("hii  welcome to my jsp");
		%>

		<%="my page" %><br>		
		<%= LocalDate.now() %>
		
		<%! int a=10; %>
		<%
		int a=7;
		System.out.println(this.a);
		System.out.println(a);%>
</body>
</html>