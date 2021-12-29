<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/menu.css">
</head>
<body>
	<div align="center"></div>
	<div>
		<!-- 메뉴부분 -->
		<ul>
			<li><a class="active" href="home.do">Home</a></li>
			<!-- 로그인했을 때 그 값을 ssession에 값을 담아놔야함 MC로 ㄱㄱ -->
			<!-- id(session에서 가져온 id)가 null과 같으면 -->
			<c:if test="${id eq null }">
				<li><a href="memberLoginForm.do">Login</a>
			</c:if>
			<!-- id(session에서 가져온 id)가 null과 다르면  -->
			<c:if test="${id ne null }">
				<li><a href="memberLogout.do">Logout</a></li>
			</c:if>

			<li><a href="#">Contact</a></li>
			
			<!-- 6. noticeSelectList.do 콘드롤러 만들러 ㄱㄱ -->
			<li><a href="noticeSelectList.do">Notice</a></li>
			
			<li><a href="#">Product</a></li>
			<c:if test="${author eq 'ADMIN' }">
				<li><a href="#">Service</a></li>
				<li><a href="memberSelectList.do">Members</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>