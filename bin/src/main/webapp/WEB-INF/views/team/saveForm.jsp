<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form action="/team" method="POST">
		<div class="form-group">
			<input type="text" name="name" class="form-control" placeholder="팀 이름">
		</div>
		<c:forEach var="stadium" items="${stadiums}">
			<div class="form-check-inline">
				<label class="form-check-label"><input type="radio" class="form-check-input"
					name="stadium" value="${stadium.id}"> ${stadium.name}</label>
			</div>
		</c:forEach>
		<br /> <br />

		<button type="submit" class="btn btn-primary">등록하기</button>
	</form>
</div>
</body>
</html>

<script>
	
</script>