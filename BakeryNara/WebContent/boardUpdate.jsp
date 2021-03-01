<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>

<body>
	<div class="boardUpdate">
		<h1>글 수정</h1>
		<form name="frm" method="post" action="board.do">
			<input type="hidden" name="command" value="board_update"> 
			<input type="hidden" name="num" value="${board.num}">
			<table class="writingBoards">
				<tr>
					<th>작성자</th>
					<td><input type="text" size="12" name="name"
						value="${board.name}" readonly> ※변경불가 </td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="40" maxlength="50" name="email"
						value="${board.email}" readonly> ※변경불가 </td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"
						value="${board.title}">* 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content">${board.content}</textarea></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="등록" onclick="return boardCheck()"> 
				<input type="reset"value="다시 작성"> 
				<input type="button" value="목록" onclick="location.href='board.do?command=board_list'">
			</div>
		</form>
	</div>

</body>
</html>


<%@ include file="footer.jsp"%>