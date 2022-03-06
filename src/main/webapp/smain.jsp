<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "css/bootstrap.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ST's OCTA Student Details</title>
<style>
		body {
		  background-image: url('images/background.jpg');
		  background-repeat: no-repeat;
		  background-attachment: fixed;  
		  background-size: cover;
		}
	</style>
</head>
<body>
<div class = "container vh-100">
	<div class = "row justify-content-center h-100">
	<div class = "card text-center w-50 my-auto shadow">
		<div class = "card-header bg-primary text-white">
			<h5 class="font-weight-bold text-uppercase mt-3 mb-4">${heading}</h5>
		</div>
		<div class = "card-body">
			<a href="/sfilter" class="btn btn-outline-warning" style="float:right" role="button">Apply Filter</a>
			<a href="/students" class="btn btn-outline-warning" style="float:right" role="button">Reset Filter</a><br>
			<table class="table table-bordered">
				<thead>
					<tr>
					<th>Student ID</th>
					<th>Student Name</th>
					<th>Student Email</th>
					<th>Student Password</th>
					<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${courser}" var="courser">
						<tr>
						<td>${courser.sid}</td>
						<td>${courser.sname}</td>
						<td>${courser.semail}</td>
						<td>${courser.spw}</td>
						<td><a href="/studentsedit?sid=${courser.sid}&a=a" class="btn btn-info" role="button">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</div>
</body>
</html>