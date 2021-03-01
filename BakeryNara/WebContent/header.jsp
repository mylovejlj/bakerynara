<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Bakery Nara</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/brandStory.css">
<link rel="stylesheet" type="text/css" href="css/products.css">
<link rel="stylesheet" type="text/css" href="css/stores.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/join.css">
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/member.js"></script>
<script type="text/javascript" src="script/board.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.2.min.js"></script>

<script>
	//네비 메뉴
	$(document).ready(function() {
		$(".sub").hide();
		$("#backBox").hide();

		$(".menu_L").mouseover(function() {
			$(".sub").stop().slideDown("slow");
			$("#backBox").stop().fadeIn("slow");
		});

		$(".menu_L").mouseout(function() {
			$(".sub").stop().slideUp("slow");
			$("#backBox").stop().fadeOut("slow");
		});
	});

	//배너 슬라이딩
	 $(function() {
		$("#trainInner").css("width",
				1400 * $("#trainInner ul.room").size() + "px");
		$(".room:last").prependTo("#trainInner"); //room클래스 중 가장 마지막 요소를 trainInner 앞에 추가
		$("#trainInner").css("margin-left", "-1400px");

		$("#pre").click(
				function() {
					$("#pre , #next").hide();
					$("#trainInner").animate(
							{
								marginLeft : parseInt($("#trainInner").css(
										"margin-left"))
										+ 1400 + "px"
							}, "slow", "swing", function() {
								$("#trainInner").css("margin-left", "-1400px");
								$(".room:last").prependTo("#trainInner");
								$("#pre , #next").show();
							});
				});

		$("#next").click(
				function() {
					$("#pre, #next").hide();
					$("#trainInner").animate(
							{
								marginLeft : parseInt($("#trainInner").css(
										"margin-left"))
										- 1400 + "px"
							}, "slow", "swing", function() {
								$("#trainInner").css("margin-left", "-1400px");
								$(".room:first").appendTo("#trainInner");
								$("#pre, #next").show();
							});
				});

		var timerId = setInterval(function() {
			$("#next").click();
		}, 2500);

		$("#pre img, #next img").click(function() {
			clearInterval(timerId)
		});
	}); 
</script>

<header id="header">
	<!--로고 -->
	<h1 class="logo">
		<a href="index.jsp"><img src="images/logo.png" width="330"
			height="90"></a>
	</h1>
</header>
</head>

<body>
	<div id="contentsArea">
		<div id="container">
			<div id="container_L">
				<ul class="nav_L">
					<div id="backBox"></div>
					<li class="menu_L"><a href="brandStory.jsp"> BRAND </a>
						<ul class="sub">
							<li><a href="brandStory.jsp"> BRAND STORY </a></li>
						</ul></li>
					<li class="menu_L"><a href="newItems1.jsp"> PRODUCT </a>
						<ul class="sub">
							<li><a href="newItems1.jsp"> 신제품 </a></li>
							<li><a href="breads1.jsp"> 빵 </a></li>
							<li><a href="cakes1.jsp"> 케이크 </a></li>
							<li><a href="cookies1.jsp"> 쿠키 </a></li>
						</ul></li>
					<li class="menu_L"><a href="store1.jsp"> STORES </a>
						<ul class="sub">
							<li><a href="store1.jsp"> 삼성본점 </a></li>
							<li><a href="store2.jsp"> 분당 서현점 </a></li>
							<li><a href="store3.jsp"> 잠실 롯데점 </a></li>
						</ul></li>
					<li class="menu_L"><a href="board.do?command=board_list">
							COMMUNITY </a>
						<ul class="sub">
							<li><a href="board.do?command=board_list"> 공지사항 </a></li>
						</ul></li>
				</ul>
			</div>
			<div id="container_R">
				<ul class="nav_R">
					<c:choose>
						<c:when test="${loginUser.userid ne null}">
							<li><p>
									<span>${loginUser.name}</span>( ${loginUser.userid})님, 환영합니다!
								</p></li>
							<div class="buttons_main">
								<input class="memUpdateBtn_main" type="button" value="회원정보변경"
									onclick="location.href='member.do?command=pwd_check_form&userid=${loginUser.userid}'" />
								<input class="logoutBtn_main" type="submit" value="로그아웃"
									onclick="return logout()" />
							</div>
						</c:when>
						<c:otherwise>
							<li><a href="loginForm.jsp"> LOGIN </a></li>
							<li><a href="joinForm.jsp"> JOIN US </a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>