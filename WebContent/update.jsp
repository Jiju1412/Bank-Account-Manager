<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.* , com.cestar.model.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<% 

	bank banks = (bank)session.getAttribute("bankToBeUpdated");
	
%>

<form action="update"  class="container" style="width:300px ;margin-left :30px ">

<div class="form group">
<label for="id">Account Id:</label>
<input type="text" id="id" name="id" class="form-control"  value="<%=banks.getAccountId() %>">
</div>

<div class="form group">
<label for="type">Account Type:</label>
<input type="text" id="type" name="type" class="form-control" value="<%=banks.getAccountType() %>">
</div>

<div class="form group">
<label for="name">Account Name:</label>
<input type="text" id="name" name="name" class="form-control" value="<%=banks.getAccountName() %>">
</div>

<div class="form group">
<label for="contact">Account Contact:</label>
<input type="text" id="contact" name="contact" class="form-control"  value="<%=banks.getAccountContact() %>">
</div>

<div class="form group">
<label for="balance">Account Balance:</label>
<input type="text" id="balance" name="balance" class="form-control"  value="<%=banks.getAccountBalance() %>">
</div>

<div class="form group">
<label for="date">Account Balance:</label>
<input type="text" id="date" name="date" class="form-control"  value="<%=banks.getAccountDate() %>">
</div>

<br>
<button type="submit" class="btn btn-info">Update Account</button>
</form>
</body>
</html>