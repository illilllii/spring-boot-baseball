<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form action="/player" method="POST">
		<div class="form-group">
			<input type="text" class="form-control" name="name" placeholder="선수이름">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="position" placeholder="포지션">
		</div>

		<c:forEach var="team" items="${teams}">
			<div class="form-check-inline">
				<label class="form-check-label"><input type="radio" class="form-check-input" name="team"
					value="${team.id}"> ${team.name}</label>
			</div>
		</c:forEach>
		<br /> <br />
		<button class="btn btn-primary">등록하기</button>
	</form>
</div>
</body>
</html>