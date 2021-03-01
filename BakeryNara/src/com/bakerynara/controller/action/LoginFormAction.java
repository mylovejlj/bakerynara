package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "loginForm.jsp";
		
		HttpSession session = request.getSession();
		
		//이미 로그인 한 사람이라면 (세션에 남아있다면) 이동
		if(session.getAttribute("loginUser") != null) {
			path = "index.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
