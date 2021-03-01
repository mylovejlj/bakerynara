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

<title>관리자 번호 확인</title>
<body>
<div class="adminnoCheck">
	<h2>관리자 번호 확인</h2>
	<form action="member.do" method="get" name="frmAdminChk">
		<input type="hidden" name="command" value="admin_check_updt">
		관리자 번호 <input id="adminno" type=text name="adminno" value="${adminno}">
		<input id="adminnoCheckBtn" type=submit value="확인" onclick="adminNoCheck_updt('${adminno}')"> <br>
		<c:if test="${result == false}">
			<script type="text/javascript">
			opener.frmUpdt.adminno.value = "";
			</script>
			${adminno}는 관리자정보에 존재하지 않습니다.
		</c:if>
		<c:if test="${result == true}">
			${adminno}는 사용 가능한 번호입니다.
			<input id="adminnoOkBtn" type="button" value="사용" class="cancel" onclick="adminnoOk_updt('${adminno}')">
		</c:if>
	</form>
</div>
</body>
</html>
