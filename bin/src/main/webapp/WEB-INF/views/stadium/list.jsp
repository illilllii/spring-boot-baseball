<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
<h1>야구장 관리</h1> <br />
	<table class="table">
		<thead>
			<tr>
				<th>No</th>
				<th>구장</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadium" items="${stadiums}">
				<tr id="stadium-${stadium.id}">
					<td>${stadium.id}</td>
					<td>${stadium.name}</td>
					<td>${stadium.team.name}</td>
					<td><button type="button" class="btn btn-danger" onclick="deleteById(${stadium.id})">삭제</button></td>
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
			url: "/stadium/"+id,
			dataType: "json"
		}).done((res)=>{
			$("#stadium-"+id).remove();
		});
	}
</script>
</html>