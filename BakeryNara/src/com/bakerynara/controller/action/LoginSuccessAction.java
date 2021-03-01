package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSuccessAction  implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "login.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);
	}

}
