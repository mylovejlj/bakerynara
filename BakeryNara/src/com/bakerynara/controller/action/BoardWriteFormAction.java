package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action {
	
	//웹 요청을 처리하고 응답하기 위한 메소드를 재정의
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라메터로 넘어온 주소값(path)을 변수에 셋팅
		String path = "boardWrite.jsp";
		
		//페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
