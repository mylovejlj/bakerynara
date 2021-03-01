<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="header.jsp"%>

<body>
	<div class="boardView">
		<h1>글 상세</h1>
		<table class="viewingBoards">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
				<th>이메일</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writedate}" /></td>
				<th>조회수</th>
				<td>${board.readcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${board.content}</pre></td>
			</tr>
		</table>
		<div class="buttons">
			<input type="button" value="게시글 목록"
				onclick="location.href='board.do?command=board_list&page=${param.page}'">
			<c:if test="${loginUser.admin eq 1}">
				<input type="button" value="현재글 수정"
					onclick="location.href='board.do?command=board_update_form&num=${board.num}'">
				<input type="button" value="현재글 삭제"
					onclick="return deleteCheck(${board.num})">
				<input type="button" value="새 글 등록"
					onclick="location.href='board.do?command=board_write_form'">
			</c:if>
		</div>
	</div>
</body>
</html>

<%@ include file="footer.jsp"%>