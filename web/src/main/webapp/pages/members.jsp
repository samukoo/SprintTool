<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<p>Team tool!</p>



	<div class="col-md-6">
		<table class="table">
			<thead>
				<tr>
					<th>nimi</th>
					<th>rooli</th>
					<th>team</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="member">
					<tr>
						<td><a href="user?user=${member.mid}">${member.name}</a> </td>
						<td>${member.role}</td>
						<td><a href="team/${member.team.eid}">${member.team.team_description}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<p>
	<form action="members" method="post">
		First name:<br> <input type="text" name="firstname" value=""><br>
		Last name:<br> <input type="text" name="lastname" value=""><br>
		Role:<br> 
		<select name ="role">
			<c:forEach items="${roles}" var="role">
				<option value="${role}">${role}</option>
			</c:forEach>
		</select><br>
		Team:<br> 
		<c:forEach items="${teams}" var="team">
			<input type="radio" name="team" value="${team.eid}">${team.team_name}<br> 
		</c:forEach>

		




		<button type="submit" class="btn btn-info">Main</button>



	</form>
	</p>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>