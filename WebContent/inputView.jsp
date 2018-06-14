<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	requestScope : ${requestScope.result}
	<br>

	<c:choose>
		<c:when test="${requestScope.result > 0}">

		입력이 성공하였습니다.
		3초 후 index.html 화면으로 다시 이동하겠습니다.

<script>
	setInterval(function() {
		location.href = "index.jsp"
	}, 3000)
</script>


		</c:when>

		<c:when test="${requestScope.result==0 }">
		입력에 실패하였습니다. 관리자에게 문의하시기 바랍니다.
</c:when>
	</c:choose>

</body>
</html>