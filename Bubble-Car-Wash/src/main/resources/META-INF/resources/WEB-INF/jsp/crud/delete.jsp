<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bubble Car Wash Application</title>
</head>
<body>
<center>
	<h1>Bubble Car Wash</h1>
	<div>
		<table border=1>
		<tr>
			<td><a href="/allentries">All Entries</a></td>
			<td><a href="/add">Add Entry</a></td>
			<td><a href="/update">Update Entry</a></td>
			<td><a href="/delete">Delete Entry</a></td>
			<td><a href="/searchbydate">Search by Date</a></td>
			<td><a href="/searchbyepochdate">Search by Epoch Date</a></td>
			<td><a href="/searchbyregistration">Search by Registration</a></td>
			<td><a href="/searchbycartypeanddate">Search by Car Type and Date</a></td>
		</tr>
	</table>
	</div>
	<h2>Delete Entry</h2>
	<form method="POST" action="deleteentry">
		<table border=1 style="text-align:center;">
			<tr>
				<td><b>UUID</b></td>
				<td><input type="text" name="uuid"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete Entry"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>