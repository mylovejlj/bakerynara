<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<body>
	<div class="boardWrite">
		<h1>글 등록</h1>
		<form name="frm" method="post" action="board.do">
			<input type="hidden" name="command" value="board_write">
			<table class="writingBoards">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" maxlength="15" placeholder="최대 15자"> * 필수</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" maxlength="50" placeholder="최대 50자"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title" maxlength="30" placeholder="최대30자"> * 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content" maxlength="500" placeholder="최대 500자"></textarea></td>
				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="등록" onclick="return boardCheck()"> 
				<input type="reset"	value="다시 작성"> 
				<input type="button" value="목록" onclick="location.href='board.do?command=board_list'">
			</div>
		</form>
	</div>

</body>
</html>


<%@ include file="footer.jsp"%>