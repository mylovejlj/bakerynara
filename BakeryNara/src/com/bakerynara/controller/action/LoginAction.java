package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bakerynara.controller.action.Action;
import com.bakerynara.dao.MemberDAO;
import com.bakerynara.dto.Member;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 폼태그에서 넘어오는 건 전부 쿼리문으로 넘어오기 때문에, getParameter로 쿼리문을 받아준다.
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		// 데이터베이스에 접근하기 위하여 DAO객체를 생성
		MemberDAO memberDao = MemberDAO.getInstance();

		// 데이터베이스에 접근 한 결과를 담기 위한 변수
		boolean result = memberDao.userCheck(userid, pwd);

		// 결과가 true라면. 즉 가입 되어있는 사람이라면
		if (result) {

			// 그 사용자 ID를 받아서 Member(VO)에 격납
			Member loginUser = memberDao.getMember(userid);

			// 세션에 세션을 세팅.
			// request.getSession(); 이미 세션이 있다면 그 세션을 돌려주고, 세션이 없으면 ()안이 true라면 새로운 세션을 생성한다.
			HttpSession session = request.getSession();
			// "loginUser"를 사용하여 loginUser라는 객체를 세션에 바인딩한다.(연결한다)
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("userid", userid);
			
			//세션의 유효기간을 1분
			session.setMaxInactiveInterval(60);
			
			
			
			// LoginSuccessAction 클래스를 실행하여 페이지 이동
			new LoginSuccessAction().execute(request, response);

		} else {
			// 결과가 false라면. 즉 가입 되어있지 않거나, ID/PW가 틀려서 DB정보와 일치하지 않는다면
			request.setAttribute("message", "아이디 또는 암호가 맞지 않거나 존재하지 않습니다.");
			request.setAttribute("userid", userid);
			
			// 로그인 화면으로 이동
			new LoginFormAction().execute(request, response);
		}

	}

}
