<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="header.jsp"%>

<body>
	<div class="join">
		<c:if test="${command eq 'join'}">
			<h1>WELCOME</h1>
			<div id="resultMsg">${member.name}(${member.userid})님! 가입을 환영합니다!</div>
			<h2>가입하신 정보</h2>
		</c:if>
		<c:if test="${command eq 'member_update'}">
			<h1>UPDATE</h1>
			<div id="resultMsg">${member.name}(${member.userid})님의 정보가 수정되었습니다.</div>
			<h2>수정하신 정보</h2>
		</c:if>

		<table class="memberInfo">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>등급</th>
			</tr>
			<tr>
				<td>${member.userid}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.phone}</td>
				<td>${member.email}</td>
				<td><c:if test="${ member.admin == 0}">일반 회원</c:if> <c:if
						test="${ member.admin == 1}">관리자</c:if></td>
			</tr>
		</table>
		<div class="buttons">
		<c:if test="${command eq 'join'}">
			<input class="goTologinBtn" type="submit" value="로그인화면으로"
				onclick="location.href='member.do?command=login_form'" /> 
				</c:if>
		<c:if test="${command eq 'member_update'}">
		<input class="goToMainBtn" type="submit" value="메인화면으로"
				onclick="location.href='index.jsp'" />
		</c:if>
		<input
				class="memUpdateBtn" type="button" value="회원정보변경"
				onclick="location.href='member.do?command=pwd_check_form&userid=${member.userid}'" />
		</div>
	</div>
</body>
</html>

<%@ include file="footer.jsp"%>