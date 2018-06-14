<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
	text-align: center;
}
</style>
<script>
window.onload = function(){
	document.getElementById("toInput").onclick = function() {
		location.href = "input.do";		
	}
	document.getElementById("toOutput").onclick = function(){
		location.href = "output.do";
	}
}
</script>
</head>


<body>

	<table border=1>

		<tr>
			<th colspan=2>메세지
		<tr>
			<td><button id="toInput">input</button>
			<td><button id="toOutput">output</button>
	</table>

</body>
</html>