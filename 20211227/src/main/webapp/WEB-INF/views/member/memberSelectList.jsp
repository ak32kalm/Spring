<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center">
		<div>
			<h3>회원목록</h3>
		</div>
	</div>
		<!-- key,value // key, name or -->
		<div>
			<form id="frm" action="" method="post">
				<select id="key" name="key">
					<!-- 디폴트값으로  전체 선택 -->
					<option value="" selected="selected">전 체</option>
					<option value="name">이 름</option>
					<option value="tel">전화번호</option>
					<option value="address">주 소</option>
				</select> <input type="text" id="data" name="data" size="20"
					onkeypress="eventKey(this);">&nbsp;
				<button type="button" onclick="searchData()">검 색</button>
			</form>
		</div>
		<br>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="150">아 이 디</th>
						<th width="150">이 름</th>
						<th width="150">전화번호</th>
						<th width="250">주 소</th>
						<th width="100">권 한</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${members }" var="member">
						<tr>
							<td align="center">${member.id }</td>
							<td align="center">${member.name }</td>
							<td align="center">${member.tell }</td>
							<td>&nbsp;${member.address }</td>
							<td align="center">${member.author }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<script type="text/javascript">
		function eventKey(enterKey) {
			if(event.keyCode == 13){ //아스키코드 13 (7비트 아스키 128문자를 표현할 수 있는 것이 아스키 코드)
				searchData();				
			}else {
				return false;
			}
		}
		
		function searchData() {
			$.ajax({
				url : "ajaxSearchMember.do",
				type : "post",
				data : {"key" : $("#key option:selected").val(), "data" : $("#data").val()},
				datType : "json"
				success : function(result) {
					console.log(result);
					alert(result);
					if(result.length > 0){
							htmlView(result);						
					}else{
						alert("검색조건을 만족한느 데이터가 없습니다.");
					}
				}		
					
			});
		}
		
		function htmlView(result) {
			$.each(result, function(index, item)) {
				var row = $("")
			}
		}
		
		
		
		
		
		</script>
</body>
</html>