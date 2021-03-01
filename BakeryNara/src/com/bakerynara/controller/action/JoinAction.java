package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bakerynara.dao.MemberDAO;
import com.bakerynara.dto.Member;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Member member = new Member();

		member.setUserid(request.getParameter("userid"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setAdmin(Integer.parseInt(request.getParameter("admin")));

		// 데이터베이스에 접근하기 위하여 DAO객체를 생성. 싱글톤 방식.
		MemberDAO memberDao = MemberDAO.getInstance();

		// 데이터베이스에 접근 한 결과를 변수 result에 셋팅
		int result = memberDao.insertMember(member);

		if (result == 1) {

			// 화면 판별용 변수 command
			String command = request.getParameter("command");
			
			// 비밀번호 부분 암호화
			String pwd = request.getParameter("pwd");
			String visibleStr = pwd.substring(0, 2);
			String notVisibleStr = pwd.substring(2).replaceAll(".", "*");

			pwd = visibleStr + notVisibleStr;
			
			member.setPwd(pwd);
			
			// 세션에 세션을 세팅.
			// request.getSession(); 이미 세션이 있다면 그 세션을 돌려주고, 세션이 없으면 새로운 세션을 생성한다.
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			session.setAttribute("command", command);

			// BoardListAction 클래스를 실행하여 페이지 이동
			new JoinSuccessAction().execute(request, response);

		} else {

			request.setAttribute("message", "회원 가입에 실패했습니다.");
			// 로그인 화면으로 이동
			new LoginFormAction().execute(request, response);

		}

	}

}
