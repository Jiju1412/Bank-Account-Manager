<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.* , com.cestar.model.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<%
List<bank> banks = (ArrayList)session.getAttribute("bankdetails");
%>

<table class="table table-striped">

	<tr>
		<th>AccountId</th>
		<th>AccountType</th>
		<th>AccountName</th>
		<th>AccountContact</th>
		<th>AccountBalance</th>
		<th>AccountDate</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	
	<% for(bank bnk:banks) { %>
	
	<tr>
	
	<td><%= bnk.getAccountId() %></td>
	<td><%= bnk.getAccountType() %></td>
	<td><%= bnk.getAccountName() %></td>
	<td><%= bnk.getAccountContact() %></td>
	<td><%= bnk.getAccountBalance() %></td>
	<td><%= bnk.getAccountDate() %></td>
	<td> <a href="edit?id=<%=bnk.getAccountId() %>" class="btn btn-success" >Update</a> </td>
	<td> <a href="delete?id=<%=bnk.getAccountId() %>" class="btn btn-info" >Delete</a> </td>
	
	</tr>	
	
	<% } %>

</table>

<a href="insert" class="btn btn-danger">Create Account</a>

</body>
</html>