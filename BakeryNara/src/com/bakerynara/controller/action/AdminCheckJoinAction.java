package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bakerynara.dao.MemberDAO;

public class AdminCheckJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

		String path = "admincheck_join.jsp";

		String adminno = request.getParameter("adminno");

		// 데이터베이스에 접근하기 위하여 DAO객체를 생성
		MemberDAO memberDao = MemberDAO.getInstance();

		// 데이터베이스에 접근 한 결과를 담기 위한 변수
		// 사용가능 : true, 사용불가능 : false
		boolean result = memberDao.confirmAdmin(adminno);

		request.setAttribute("adminno", adminno);
		request.setAttribute("result", result);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
