<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  /member.do로 DispatcherServlet에 요청합니다. -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>

<%@ include file="header.jsp"%>

<body>
	<div class="loginForm">
		<h1>LOGIN</h1>
		<div class="loginBox">
			<h2>회원 로그인</h2>
			<div class="msg">${message}</div>
			<div class="loginWriteBox">
				<form action="member.do" class="frmLogin" name="frmLogin"
					method="post">
					<input type="hidden" name="command" value="login">
					<div class="inputWrap">
						<div class="fld">
							<input type="text" name="userid" class="inputForm" value="${userid}"
								placeholder="아이디">
						</div>
						<div class="fld">
							<input type="password" name="pwd" class="inputForm"
								placeholder="비밀번호">
						</div>
					</div>
					<div class="loginButtons">
						<input type="submit" value="로그인" onclick="return loginCheck()">
					</div>
				</form>
			</div>
			<div class="joinButtonBox">
				<h3>아직 회원이 아니신가요?</h3>
				<h4>회원이 되시면 포인트 적립, 이벤트 참여 등 다양한 혜택을 누리실 수 있습니다!</h4>
				<div class="joinButtons">
					<input type="button" value="신규회원가입"
						onclick="location.href='member.do?command=join_form'" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%@ include file="footer.jsp"%>