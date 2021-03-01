<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="header.jsp"%>

<body>
	<form action="member.do">
		<input type="hidden" name="command" value="logout">
		<div class="login">
			<h1>WELCOME</h1>
			<div>안녕하세요. ${loginUser.name}(${loginUser.userid})님! 로그인을
				환영합니다!</div>
		</div>
		<div class="buttons">
			<input class="homeBtn" type="button" value="메인화면으로"
				onclick="location.href='index.jsp'" /> <input class="memUpdateBtn"
				type="button" value="회원정보변경"
				onclick="location.href='member.do?command=pwd_check_form&userid=${loginUser.userid}'" />
			<input class="logoutBtn" type="submit" value="로그아웃" onclick="return logout()"/>
		</div>
	</form>
</body>
</html>

<%@ include file="footer.jsp"%>