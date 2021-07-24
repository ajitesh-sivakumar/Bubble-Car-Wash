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
	<h2>Add Entry</h2>
	<form method="POST" action="addentry">
		<table border=1 style="text-align:center;">
			<tr>
				<td><b>UUID</b></td>
				<td>(Auto Generated)</td>
			</tr>
			<tr>
				<td><b>Make:</b> </td>
				<td>
					<select name="make" id="make">
					  <option value="Ford">Ford</option>
					  <option value="Toyota">Toyota</option>
					  <option value="Mitsubishi">Mitsubishi</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><b>Model:</b> </td>
				<td>
					<input type="text" name="model">
				</td>
			</tr>
			<tr>
				<td><b>Body:</b> </td>
				<td>
					<select name="body" id="body">
					  <option value="Sedan">Sedan</option>
					  <option value="Hatchback">Hatchback</option>
					  <option value="SUV">SUV</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><b>Registration: </b></td>
				<td><input type="text" name="registration"></td>
			</tr>
			<tr>
				<td><b>Color: </b></td>
				<td><input type="text" name="color"></td>
			</tr>
			<tr>
				<td><b>Wash Type:</b></td>
				<td>
					<select name="washtype" id="washtype">
					  <option value="Full_Wash">Full Wash</option>
					  <option value="Machine_Wash">MachineWash</option>
					  <option value="Waterless_Wash">Waterless Wash</option>
					  <option value="Soft_Touch_Wash">Soft Touch Wash</option>
					  <option value="Self_Service_Wash">Self Service Wash</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><b>Date:</b></td>
				<td><input type="text" name="date"></td>
			</tr>
			<tr>
				<td><b>Time:</b></td>
				<td><input type="text" name="time"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Entry"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>