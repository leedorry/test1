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

<% String query = request.getParameter("q"); %>
<%=query %>

<script type="text/javascript" src="js/jquery-3.5.1.js"></script>


</body>
</html>