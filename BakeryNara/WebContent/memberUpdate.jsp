<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="header.jsp"%>

<script>
	$(window).ready(function() {
		if ($('input:radio[id=user]').is(':checked')) {
			$('#adminno').hide();
		} else {
			$('#adminno').show();
		}
	});
</script>

<body>
	<div class="memberUpdate">
		<h1>회원 정보 수정</h1>
		<form action="member.do" method="post" name="frmUpdt" class="frmUpdt">
			<input type="hidden" name="command" value="member_update">
			<table class="frmUpdtTbl" align="center">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid" value="${member.userid}"
						readonly>변경불가</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" placeholder="5~20글자"
						maxLength="20">필수*</td>
				</tr>
				<tr height="30">
					<th width="80">비밀번호 확인</th>
					<td><input type="password" name="pwd_check"
						placeholder="5~20글자" maxLength="20">필수*</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${member.name}"
						readonly>변경불가</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" maxLength="20"
						value="${member.phone}">필수*</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" maxLength="50"
						value="${member.email}"></td>
				</tr>
				<tr>
					<th>등급</th>
					<td><c:choose>
							<c:when test="${member.admin==0}">
								<input id="user" type="radio" name="admin" value="0"
									checked="checked" onchange="setAdminNo()"> 일반회원
							<input id="admin" type="radio" name="admin" value="1"
									onchange="setAdminNo()"> 관리자
						</c:when>
							<c:otherwise>
								<input id="user" type="radio" name="admin" value="0"
									onchange="setAdminNo()"> 일반회원
							<input id="admin" type="radio" name="admin" value="1"
									checked="checked" onchange="setAdminNo()"> 관리자 
							</c:otherwise>
						</c:choose>
						<div id="adminno">
							<input id="adminnoInput" type="text" name="adminno" maxlength="8" placeholder="관리자번호 8자리를 입력하세요.">
							 * 필수 <input
								type="hidden" id="readminno" name="readminno"><input id="adminnoChkBtn" type="button" value="관리자번호확인"
								onclick="adminNoCheck_updt()">
						</div></td>

				</tr>
			</table>
			<div class="buttons">
				<input type="submit" value="확인" onclick="return updateCheck()">
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
</html>

<%@ include file="footer.jsp"%>