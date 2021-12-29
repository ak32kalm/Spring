<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 8. -->
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<td width="70">순번</td>
						<td width="130">작성자</td>
						<td width="250">제목</td>
						<td width="100">작성일자</td>
						<td width="70">조회수</td>
						<td width="100">첨부파일</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${notices[0].id eq null }">
						<tr>
							<td colspan="6" align="center">데이터가 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:if test="${notices ne null }">
						<c:forEach items="${notices }" var="notice">
							<tr>
								<td align="center">${notice.id}</td>
								<td align="center">${notice.writerName}</td>
								<td>${notice.title}</td>
								<td align="center">${notice.writerDate}</td>
								<td align="center">${notice.hit}</td>
								<c:if test="${notice.attache ne null }">
									<td align="center"><img src="resoures/img/file.png"></td>
								</c:if>
								<c:if test="${notice.attache eq null }">
									<td align="center"></td>
								</c:if>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
				<!-- notices로 받고 / notice라고 읽음 -->
			</table>
		</div><br>
		<div>
		<!-- 로그인 시에만 글쓰기 버튼 보여주기 -->
			<c:if test="${id ne null}">
				<button type="button" onclick="">글쓰기</button>
			</c:if>
		</div>
	</div>
</body>
</html>