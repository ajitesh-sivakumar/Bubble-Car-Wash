<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
	<h2>Search by Epoch Date</h2>
	<form method="POST" action="searchbyepochdate">
		<table border=1 style="text-align:center;">
			<tr>
				<td><b>Date</b></td>
				<td><input type="text" name="date"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br><br><br><br>
	<table border="1">
            <thead>
                <th>UUID</th>
                <th>Make</th>
                <th>Model</th>
                <th>Body</th>
                <th>Registration</th>
                <th>Color</th>
                <th>Wash Type</th>
                <th>Date</th>
                <th>Time</th>
            </thead>
            <tbody>
                <c:forEach var="list" items="${sbedlist}">
                   <tr>
                       <td>${list.getUuid()}</td>
                       <td>${list.getCarDetails().getMake()}</td>
                       <td>${list.getCarDetails().getCarModel()}</td>
                       <td>${list.getCarDetails().getBody()}</td>
                       <td>${list.getCarDetails().getRegistration()}</td>
                       <td>${list.getCarDetails().getColor()}</td>
                       <td>${list.getWashType()}</td>
                       <td>${list.getDate()}</td>
                       <td>${list.getTime()}</td>
                   </tr>
                </c:forEach>
            </tbody>
        </table>
</center>
</body>
</html>