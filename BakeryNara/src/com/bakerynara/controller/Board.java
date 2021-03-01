package com.bakerynara.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bakerynara.controller.action.Action;

/**
 * Servlet implementation class Board
 */
@WebServlet("/board.do")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라메터로 넘어 온 command값 변수에 셋팅
		String command = request.getParameter("command");
		
		//명령어를 전달할 액션팩토리 클래스 생성
		ActionFactory af = ActionFactory.getInstance();
		
		//액션팩토리에 명령어(목적지)를 세팅
		Action action = af.getAction(command);
		
		if(action != null) {
			//액션클래스로 보내어 실행
			try {
				action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
