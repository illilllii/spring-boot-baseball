<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
<h1>선수 관리</h1> <br />
	<table class="table">
		<thead>
			<tr>
				<th>No</th>
				<th>선수 이름</th>
				<th>포지션</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${players}">
				<tr id="player-${player.id}">
					<td>${player.id}</td>
					<td>${player.name}</td>
					<td>${player.position}</td>
					<td>${player.team.name}</td>
					<td><button type="button" class="btn btn-danger" onclick="deleteById(${player.id})">삭제</button></td>
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
			url: "/player/"+id,
			dataType: "json"
		}).done((res)=>{
			if(res.statusCode==1) $("#player-"+id).remove();
		});
	}
</script>
</html>