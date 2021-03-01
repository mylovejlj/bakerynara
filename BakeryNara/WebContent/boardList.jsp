<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/board.css">
<body>
	<div class="boardList">
		<h1>공지사항</h1>
		<table class="boardListTbl">
			<colgroup>
				<col width="10%" />
				<col width="50%" />
				<col width="15%" />
				<col width="15%" />
				<col width="10%" />
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.num }</td>
					<td class="title"><a
						href="board.do?command=board_view&num=${board.num}&page=${paging.page}">${board.title }</a>
					</td>
					<td>${board.name}</td>
					<td><fmt:formatDate value="${board.writedate }" /></td>
					<td>${board.readcount}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이징 부분 -->
		<jsp:include page="paging.jsp">
			<jsp:param value="${paging.page}" name="page" />
			<jsp:param value="${paging.beginPage}" name="beginPage" />
			<jsp:param value="${paging.endPage}" name="endPage" />
			<jsp:param value="${paging.prev}" name="prev" />
			<jsp:param value="${paging.next}" name="next" />
		</jsp:include>
		<c:if test="${loginUser.admin eq 1}">
			<div class="boardWriteBtn">
				<a href="board.do?command=board_write_form">글쓰기</a>
			</div>
		</c:if>
	</div>
</body>
</html>

<%@ include file="footer.jsp"%>