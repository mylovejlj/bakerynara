package com.bakerynara.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bakerynara.dao.BoardDAO;
import com.bakerynara.dao.MemberDAO;
import com.bakerynara.dto.Board;
import com.bakerynara.dto.Member;
import com.bakerynara.dto.Paging;

public class BoardListAction implements Action {

	// 웹 요청을 처리하고 응답하기 위한 메소드를 재정의
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 파라메터로 넘어온 주소값을 변수에 셋팅
		String path = "boardList.jsp";

		// DB조작을 위한 DAO인스턴스 생성
		BoardDAO boardDao = BoardDAO.getInstance();

		int page = 1;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		Paging paging = new Paging();

		int count = boardDao.getAllCount();

		paging.setPage(page);
		paging.setTotalCount(count);

		// DAO를 통하여 DB에서 데이터를 가져 온 후 리스트에 셋팅
		List<Board> boardList = boardDao.selectAllBoards(paging);

		// 값이 셋팅 된 리스트를 리퀘스트 객체에 셋팅
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", paging);

		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");

		// 데이터베이스에 접근하기 위하여 DAO객체를 생성
		MemberDAO memberDao = MemberDAO.getInstance();
		Member loginUser = memberDao.getMember(userid);

		request.setAttribute("loginUser", loginUser);

		// 목록보기 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
