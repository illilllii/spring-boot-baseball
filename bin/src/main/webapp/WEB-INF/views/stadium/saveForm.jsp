<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form action="/stadium" method="POST">
		<div class="form-group">
			<input type="text" class="form-control" name="name" placeholder="구장이름">
		</div>


		<br />
		<br />
		<button type="submit" class="btn btn-primary">등록하기</button>
	</form>
</div>
</body>
</html>