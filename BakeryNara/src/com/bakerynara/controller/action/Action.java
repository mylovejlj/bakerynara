package com.bakerynara.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	//웹 요청을 처리하고 응답하기 위한 메소드
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception;

}
