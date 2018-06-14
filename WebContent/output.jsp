<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Output View</title>
</head>
<body>

	<c:if test="${requestScope.result != null}">

		<table>
			<c:forEach var="item" items="${result}">
				<tr>
					<td>${item.name }</td>
					<td>${item.message }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>