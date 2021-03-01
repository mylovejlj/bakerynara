package com.bakerynara.controller;

import com.bakerynara.controller.action.Action;
import com.bakerynara.controller.action.AdminCheckJoinAction;
import com.bakerynara.controller.action.AdminCheckUpdtAction;
import com.bakerynara.controller.action.BoardDeleteAction;
import com.bakerynara.controller.action.BoardListAction;
import com.bakerynara.controller.action.BoardUpdateAction;
import com.bakerynara.controller.action.BoardUpdateFormAction;
import com.bakerynara.controller.action.BoardViewAction;
import com.bakerynara.controller.action.BoardWriteAction;
import com.bakerynara.controller.action.BoardWriteFormAction;
import com.bakerynara.controller.action.IdCheckAction;
import com.bakerynara.controller.action.JoinAction;
import com.bakerynara.controller.action.JoinFormAction;
import com.bakerynara.controller.action.LoginAction;
import com.bakerynara.controller.action.LoginFormAction;
import com.bakerynara.controller.action.LogoutAction;
import com.bakerynara.controller.action.MemberUpdateAction;
import com.bakerynara.controller.action.MemberUpdateFormAction;
import com.bakerynara.controller.action.PwdCheckAction;
import com.bakerynara.controller.action.PwdCheckFormAction;


public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		
		//Action 초기화
		Action action = null;
		
		//넘어온 파라메터 값이  board_list와 같을 경우. 이하 반복.
		if(command.equals("board_list")) {
			//BoardListAction 클래스 생성 후 Action 클래스에 셋팅. 이하 반복.
			action = new BoardListAction();
			
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
			
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
			
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
	
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
			
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
			
		}else if(command.equals("board_delete")){
			action = new BoardDeleteAction();
			
		}else if(command.equals("login_form")) {
			action = new LoginFormAction();
			
		}else if(command.equals("login")) {
			action = new LoginAction();
			
		}else if(command.equals("join_form")) {
			action = new JoinFormAction();
			
		}else if(command.equals("join")) {
			action = new JoinAction();

		}else if(command.equals("id_check")) {
			action = new IdCheckAction();
			
		}else if(command.equals("pwd_check")) {
			action = new PwdCheckAction();
			
		}else if(command.equals("pwd_check_form")) {
			action = new PwdCheckFormAction();
			
		}else if(command.equals("logout")) {
			action = new LogoutAction();
			
		}else if(command.equals("member_update_form")) {
			action = new MemberUpdateFormAction();
			
		}else if(command.equals("member_update")) {
			action = new MemberUpdateAction();
			
		}else if(command.equals("admin_check_join")) {
			action = new AdminCheckJoinAction();
			
		}else if(command.equals("admin_check_updt")) {
			action = new AdminCheckUpdtAction();
			
		} 
		
		
		
		//생성 된 Action 값 리턴
		return action;
	}
		
	
	
}
