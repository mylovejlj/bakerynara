package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bakerynara.dao.MemberDAO;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "idcheck.jsp";

		String userid = request.getParameter("userid");
		
		//데이터베이스에 접근하기 위하여 DAO객체를 생성
		MemberDAO memberDao  = MemberDAO.getInstance();
		
		//데이터베이스에 접근 한 결과를 담기 위한 변수
		//사용가능 : true, 사용불가능 : false
		boolean result = memberDao.confirmID(userid);
		
		//System.out.println(result);
		
		
	
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);

		request.getRequestDispatcher(path).forward(request, response);
	}

}
