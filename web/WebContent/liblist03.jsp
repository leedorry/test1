<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>영업상태</th>
				<th>업태구분명</th>
				<th>사업자명</th>
				<th>도로명주소</th>
				<th>지번주소</th>
				<th>전화번호</th>
				<th>좌표정보</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<button id="testBtn">테스트</button>
	<div id="getjson"></div>
	<div id="ajax"></div>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<!-- <script type="text/javascript" src="js/lib01.js" charset="UTF-8"></script> -->
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> -->
<script type="text/javascript">

$(document).ready(function(){
	$("#testBtn").click(function(){
		$.getJSON("http://localhost:8080/WebContent/liblist03.jsp?callback=?", function(d){
			$.each(d, function(k,v){
				$("#getjson").append("<div>"+k+":"+v+"</div>");;
			});
			$("#getjson").show();
		});

		$.ajax({
			url: "http://localhost:8080/WebContent/liblist03.jsp",
			dataType: "jsonp",
			jsonpCallback: "callback",
			success: function(d){
				$.each(d, function(k,v){
					$("#ajax").append("<div>"+k+":"+v+"</div>");
				});
				$("#ajax").show();
			}
		});
	});
});
</script>



</body>
</html>