package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	//DBCP 연결을 위한 메서드
	public static Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		//1. InitialContext 객체를 생성합니다.
		Context initContext = new InitialContext();
		//2. 컨텍스트 객체의 lookup 메서드로 DBCP에서 지정한 이름을 찾습니다.
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		//3. server.xml 파일의 <Resource> 태그의 name 속성을 찾습니다.
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		//4.DB 연결
		conn = ds.getConnection();
		
		//5.연결 된 Connection객체 반환
		return conn;
	}
	
	//Select 문을 실행한 후 리소스 해제를 위한 메서드(파라메터 값이 Statement일 경우)
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Select 문을 실행한 후 리소스 해제를 위한 메서드(파라메터 값이 PreparedStatement일 경우)
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//update,insert,delete 문을 실행한 후 리소스 해제를 위한 메서드(파라메터 값이 PreparedStatement일 경우)
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//update,insert,delete 문을 실행한 후 리소스 해제를 위한 메서드(파라메터 값이 Statement일 경우)
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
