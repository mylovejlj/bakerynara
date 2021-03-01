package com.bakerynara.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bakerynara.dao.BoardDAO;
import com.bakerynara.dto.Board;

public class BoardUpdateAction implements Action {

	// 웹 요청을 처리하고 응답하기 위한 메소드를 재정의
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 값의 저장과 반환을 위한 DTO객체 생성
		Board board = new Board();

		// 파라메터로 넘어 온 각 칼럼의 값들을 DTO객체에 셋팅
		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setName(request.getParameter("name"));
		board.setEmail(request.getParameter("email"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));

		// DB조작을 위한 DAO인스턴스 생성
		BoardDAO boardDao = BoardDAO.getInstance();

		// 값이 셋팅 된 DTO객체를 DAO에 전달하여 DB값 수정
		boardDao.updateBoard(board);

		// BoardListAction 클래스를 실행하여 페이지 이동
		new BoardListAction().execute(request, response);

	}

}
