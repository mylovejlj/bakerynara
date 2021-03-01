<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<link rel="stylesheet" type="text/css" href="css/join.css">
<script type="text/javascript" src="script/member.js"></script>

<title>아이디 중복확인</title>
<body>
<div class="idCheck">
	<h2>아이디 중복 확인</h2>
	<form action="member.do" method="get" name="frmIdChk">
		<input type="hidden" name="command" value="id_check">
		아이디 <input id="userid" type=text name="userid" value="${userid}"> 
		<input id="idCheckBtn" type=submit value="중복 체크" onclick="idCheck('${userid}')"> <br>
		<c:if test="${result == false}">
			<script type="text/javascript">
			opener.frmJoin.userid.value = ""; /* 부모.opener 자기자신은 self */
			</script>
			${userid}는 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result == true}">
			${userid}는 사용 가능한 아이디입니다.
			<input id="idOkBtn" type="button" value="사용" class="cancel" onclick="idOk('${userid}')">
		</c:if>
	</form>
</div>
</body>
</html>
