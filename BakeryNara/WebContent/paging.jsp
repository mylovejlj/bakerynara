<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<div class="paging">
<!-- 1~10까지 있는 페이지의 페이징 -->
<c:url var="action" value="/board.do"/>


<c:if test="${param.prev}">
    <a id="pagingBtn" href="${action}?page=${param.beginPage-1}&command=board_list">&lt;&lt;PREV</a>
</c:if>
<!-- 현재 페이지는 링크 없이 출력 -->
<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
    <c:choose>
        <c:when test="${param.page==index}">
            <strong>${index}</strong>
        </c:when>
        <c:otherwise>
            <a id="pageNum" href="${action}?page=${index}&command=board_list">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>

<c:if test="${param.next}">
    <a id="pagingBtn" href="${action}?page=${param.endPage+1}&command=board_list">NEXT&gt;&gt;</a>
</c:if>

</div>
</body>
</html>


