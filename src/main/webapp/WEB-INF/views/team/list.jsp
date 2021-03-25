<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
<h1>팀 관리</h1> <br />
	<table class="table">
		<thead>
			<tr>
				<th>No</th>
				<th>팀</th>
				<th>구장</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr id= "team-${team.id}">
					<td>${team.id}</td>
					<td>${team.name}</td>
					<td>${team.stadium.name}</td>
					<td><button type="button" class="btn btn-danger" onclick="deleteById(${team.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
<script>
	function deleteById(id) {
		$.ajax({
			type: "DELETE",
			url: "/team/"+id,
			dataType: "json"
		}).done((res)=>{
			if(res.statusCode==1) $("#team-"+id).remove();
		});
	}
</script>
</html>