package com.bakerynara.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bakerynara.dao.MemberDAO;

public class PwdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String userid = (String) session.getAttribute("userid");
		String pwd = request.getParameter("pwd");

		String path = "member.do?command=member_update_form&userid=" + userid;

		// 데이터베이스에 접근하기 위하여 DAO객체를 생성
		MemberDAO memberDao = MemberDAO.getInstance();

		// 데이터베이스에 접근 한 결과를 담기 위한 변수
		// 사용가능 : true, 사용불가능 : false
		boolean result = memberDao.confirmPwd(userid, pwd);

		if (result) {

			request.setAttribute("userid", userid);

			request.getRequestDispatcher(path).forward(request, response);

		} else {

			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('등록된 비밀번호와 일치하지 않습니다.');history.back();</script>");

			out.flush();

		}

	}

}
