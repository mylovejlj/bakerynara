package com.bakerynara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bakerynara.dto.Member;

import util.DBManager;

//DAO : 데이터베이스에 접근하기 위한 객체.레코드의 조회, 추가, 수정, 삭제 역할
public class MemberDAO {

	// 싱글톤 패턴 만들기
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// 사용자의 정보가 올바르게 DB에 존재하는지 체크하는 메서드
	public boolean userCheck(String userid, String pwd) {

		// 일단 체크 할 리턴 값은 false
		boolean result = false;

		// DB에 접근할 때 쓰일 SQL문
		String sql = "SELECT pwd FROM member where userid=?"; // SELECT * FROM member where userid=? 으로 써도됨

		Connection conn = null;

		// SELECT문 이지만 뒤에 조건절이 붙을때는 PreparedStatement사용(원래는 SELECT문은 stmt사용)
		PreparedStatement pstmt = null;

		// SQL문의 결과를 담을 곳
		ResultSet rs = null;

		// DB연결 시 반드시 try catch문 사용
		try {

			// DB 연결
			conn = DBManager.getConnection();

			// prepareStatement 객체에 sql문 셋팅
			pstmt = conn.prepareStatement(sql);

			// 거기에 바인딩 변수(조회할 칼럼) 셋팅
			pstmt.setString(1, userid);

			// SQL문을 실행하여 결과 셋팅
			// ※sql문에 조건절이 존재할 경우에는 executeQuery() 안에 sql 매개변수를 넣지 않습니다.
			rs = pstmt.executeQuery();

			// 실행한 결과 값이 존재한다면(nextInt로 읽어들일 값이 있다면) 즉, 가입된 사용자라면
			if (rs.next()) {

				// DB에 존재하는 pwd 값과, 매개변수로 넘어 온 (사용자가 입력 한 값)값이 일치한다면
				if (rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {

					// 조회 결과를 true로 셋팅
					result = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// DB 해제.
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 조회 결과를 리턴
		return result;
	}

	// 아이디로 회원 정보를 가져오기
	public Member getMember(String userid) {

		Member member = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE userid=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				member = new Member();

				member.setUserid(rs.getString("userid"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAdmin(rs.getInt("admin"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return member;

	}

	// 사용가능 : true, 사용불가능 : false
	public boolean confirmID(String userid) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT userid FROM member WHERE userid=?";

		try {
			// DB 연결
			conn = DBManager.getConnection();

			// prepareStatement 객체에 sql문 셋팅
			pstmt = conn.prepareStatement(sql);

			// 거기에 바인딩 변수(조회할 칼럼) 셋팅
			pstmt.setString(1, userid);

			// SQL문을 실행하여 결과 셋팅
			// ※sql문에 조건절이 존재할 경우에는 executeQuery() 안에 sql 매개변수를 넣지 않습니다.
			rs = pstmt.executeQuery();

			// 실행한 결과 값이 존재하지 않는다면(nextInt로 읽어들일 값이 없다면). 즉, 사용할 수 있는 아이디라면
			if (!rs.next()) {

				// 조회 결과를 true로 셋팅
				result = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public int insertMember(Member member) {

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";

		try {

			conn = DBManager.getConnection();

			// pstmt의 리턴값은 int임. 그래서 boolean이 아닌int result로 변경함
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getEmail());
			pstmt.setInt(6, member.getAdmin());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	// 회원 정보를 변경하는 메서드
	public int updateMember(Member member) {

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET pwd=?, phone=?, email=?, admin=? WHERE userid=?";
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setInt(4, member.getAdmin());
			pstmt.setString(5, member.getUserid());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public boolean confirmPwd(String userid, String pwd) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT pwd FROM member WHERE userid=?";

		try {
			// DB 연결
			conn = DBManager.getConnection();

			// prepareStatement 객체에 sql문 셋팅
			pstmt = conn.prepareStatement(sql);

			// 거기에 바인딩 변수(조회할 칼럼) 셋팅
			pstmt.setString(1, userid);

			// SQL문을 실행하여 결과 셋팅
			// ※sql문에 조건절이 존재할 경우에는 executeQuery() 안에 sql 매개변수를 넣지 않습니다.
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// DB의 비밀번호와 입력받은 비밀번가 일치할 경우
				if (rs.getString("pwd").equals(pwd)) {

					// 조회 결과 true
					result = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
// 사용자로부터 입력받은 관리자번호가 DB에 존재하는지 확인
	public boolean confirmAdmin(String adminNo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT adminno FROM adminInfo WHERE adminno=?";

		try {
			// DB 연결
			conn = DBManager.getConnection();

			// prepareStatement 객체에 sql문 셋팅
			pstmt = conn.prepareStatement(sql);

			// 거기에 바인딩 변수(조회할 칼럼) 셋팅
			pstmt.setString(1, adminNo);

			// SQL문을 실행하여 결과 셋팅
			// ※sql문에 조건절이 존재할 경우에는 executeQuery() 안에 sql 매개변수를 넣지 않습니다.
			rs = pstmt.executeQuery();

			// 실행한 결과 값이 존재한다면. 즉, 존재하는 번호라면
			if (rs.next()) {

				// 조회 결과를 true로 셋팅
				result = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return result;
	}
}