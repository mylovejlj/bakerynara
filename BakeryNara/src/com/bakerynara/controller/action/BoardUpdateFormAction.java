package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bakerynara.dao.BoardDAO;
import com.bakerynara.dto.Board;

public class BoardUpdateFormAction implements Action {

	//웹 요청을 처리하고 응답하기 위한 메소드를 재정의
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라메터로 넘어온 주소값(url)과 게시글 번호(num)를 변수에 셋팅
		String url = "boardUpdate.jsp";
		String num = request.getParameter("num");
		
		//DB조작을 위한 DAO인스턴스 생성
		BoardDAO boardDao = BoardDAO.getInstance();
		
		//일단, DAO를 통하여 DB의 조회수 칼럼의 값 증가시킴
		boardDao.updateReadCount(num);
		
		//DAO를 통하여 DB에서 하나의 데이터만 가져온 후 DTO객체에 셋팅
		Board board = boardDao.selectOneBoardByNum(num);
		
		//값이 셋팅 된 DTO객체를 리퀘스트 객체에 셋팅
		request.setAttribute("board", board);
		
		//페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
