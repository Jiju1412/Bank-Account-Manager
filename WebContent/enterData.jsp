<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>


<form action="enterData"  class="container" style="width:300px ;margin-left :30px ">

<div class="form group">
<label for="id">Account Id:</label>
<input type="text" id="id" name="id" class="form-control">
</div>

<div class="form group">
<label for="type">Account Type:</label>
<input type="text" id="type" name="type" class="form-control">
</div>

<div class="form group">
<label for="name">Account Name:</label>
<input type="text" id="name" name="name" class="form-control">
</div>

<div class="form group">
<label for="contact">Account Contact:</label>
<input type="text" id="contact" name="contact" class="form-control">
</div>

<div class="form group">
<label for="balance">Account Balance:</label>
<input type="text" id="balance" name="balance" class="form-control" >
</div>

<div class="form group">
<label for="date">Account Balance:</label>
<input type="text" id="date" name="date" class="form-control">
</div>

<br>
<button type="submit" class="btn btn-info">Create Account</button>

</body>
</html>