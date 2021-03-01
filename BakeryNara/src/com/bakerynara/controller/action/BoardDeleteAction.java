package com.bakerynara.controller.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bakerynara.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	// 웹 요청을 처리하고 응답하기 위한 메소드를 재정의
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 파라메터로 넘어온 게시판 글번호(num)값을 변수에 셋팅
		String num = request.getParameter("num");

		// DB조작을 위한 DAO인스턴스 생성
		BoardDAO boardDao = BoardDAO.getInstance();

		// 글번호를 파라메터로 주어, 게시글 삭제 메소드 실행
		boardDao.deleteBoardByNum(num);

		// 삭제 확인 팝업
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println(
				"<script language='javascript'>setTimeout(function(){location.reload();},3000); alert('삭제 되었습니다.');</script>");

		// BoardListAction 클래스를 실행하여 페이지 이동
		new BoardListAction().execute(request, response);

	}

}
