<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="header.jsp"%>

<link rel="stylesheet" type="text/css" href="css/join.css">
<script type="text/javascript" src="script/member.js"></script>

<body>
	<div class="pwdCheck">
		<h1>비밀번호 확인</h1>
		<h2>
			개인정보 보호를 위하여 <span>${loginUser.name}</span>( ${loginUser.userid})님의 비밀번호를 입력해주세요.
		</h2>
		<form action="member.do" method="get" name="frmPwdChk">
			<strong>비밀번호</strong>
			<input id="pwd" type=password name="pwd"> 
			<input id="pwdCheckBtn" type="button" value="확인" onclick="pwdCheck()">
			<br>
		</form>
	</div>
</body>
</html>

<%@ include file="footer.jsp"%>