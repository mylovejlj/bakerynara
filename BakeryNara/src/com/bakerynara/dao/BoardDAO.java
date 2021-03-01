package com.bakerynara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bakerynara.dto.Board;
import com.bakerynara.dto.Paging;

import util.DBManager;

public class BoardDAO {

	// 생성자
	private BoardDAO() {
	}

	// DAO인스턴스 생성
	/*
	 * ※static 사용 이유: 객체들이 다 같이 공유하는 데이터.객체들의 데이터와 관계없는 완벽하게 공통적인 로직을 정의할 때 사용. 따라서
	 * 인스턴스 변수/ 인스턴스 객체의 메소드에는 사용 불가
	 */
	private static BoardDAO instance = new BoardDAO();

	// 인스턴스 반환하는 메소드 생성
	public static BoardDAO getInstance() {
		return instance;
	}

	// DB조작 - 글작성 메소드
	public void insertBoard(Board board) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// DB에 넘겨 줄 sql문 셋팅
		String sql = "insert into boardNotice(num, name, email, title, content) "
				+ "values(boardNotice_seq.nextval, ?, ?, ?, ?)";
		try {

			// DB연결
			conn = DBManager.getConnection();

			// select문이 아니기때문에 prepareStatement를 사용.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());

			// DB업데이트 실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB연결 해제
			DBManager.close(conn, pstmt);
		}

	}
	/*
	 * 원래 메소드 //DB조작 - 게시글 읽어오는 메소드 public List<Board> selectAllBoards() {
	 * 
	 * //DTO 형태의 리스트 생성 List<Board> list = new ArrayList<Board>();
	 * 
	 * Connection conn = null;
	 * 
	 * Statement stmt = null; ResultSet rs = null;
	 * 
	 * //sql문 셋팅 String sql = "SELECT * FROM boardNotice ORDER BY num DESC";
	 * 
	 * 
	 * try {
	 * 
	 * //DB연결 conn = DBManager.getConnection();
	 * 
	 * //SELECT문 이지만 prepareStatement사용해도 가능 stmt = conn.createStatement();
	 * //pstmt사용 시 : pstmt = conn.prepareStatement(sql);
	 * 
	 * //DB실행하여 ResultSet에 셋팅 rs = stmt.executeQuery(sql); //pstmt 사용 시 : rs =
	 * pstmt.executeQuery();
	 * 
	 * //ResultSet에 있는 모든 데이터를 한 줄 씩 읽음 while(rs.next()) {
	 * 
	 * //값 저장 할 DTO 객체 생성 Board board = new Board();
	 * 
	 * //ResultSet으로 받아온 값을 DTO에 세팅 board.setNum(rs.getInt("num"));
	 * board.setName(rs.getString("name")); board.setEmail(rs.getString("email"));
	 * board.setTitle(rs.getString("title"));
	 * board.setContent(rs.getString("content"));
	 * board.setReadcount(rs.getInt("readcount"));
	 * board.setWritedate(rs.getTimestamp("writedate"));
	 * 
	 * //리스트에 DTO 값 추가 list.add(board); }
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }finally { //DB해제
	 * DBManager.close(conn, stmt); //pstmt 사용 시 : DBManager.close(conn, pstmt); }
	 * 
	 * //리스트 반환 return list; }
	 */

	public List<Board> selectAllBoards(Paging paging) {

		// DTO 형태의 리스트 생성
		List<Board> list = new ArrayList<Board>();

		int startNum = paging.getStartNum();
		int endNum = paging.getEndNum();

		
		String sql = "SELECT * FROM (" + "SELECT * FROM (" + "SELECT ROWNUM row_num, boardNotice.* FROM boardNotice"
				+ ") WHERE row_num >= ?" + ") WHERE row_num <= ?";

		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			// DB연결
			conn = DBManager.getConnection();

			// SELECT문 이지만 prepareStatement사용해도 가능
			// stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);

			// 바인딩 변수
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);

			// DB실행. ResultSet에 셋팅
			rs = pstmt.executeQuery();

			// ResultSet에 있는 모든 데이터를 한 줄 씩 읽음
			while (rs.next()) {

				Board board = new Board();

				// ResultSet으로 받아온 값을 DTO에 세팅
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));

				// 리스트에 DTO 값 추가
				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB해제
			DBManager.close(conn, pstmt);
			// pstmt 사용 시 : DBManager.close(conn, pstmt);
		}

		// 리스트 반환
		return list;
	}

	// DB조작 - 조회수를 증가시키는 메서드
	public void updateReadCount(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// sql문 셋팅
		String sql = "UPDATE boardNotice SET readcount=readcount+1 WHERE num=?";

		try {

			// DB연결
			conn = DBManager.getConnection();

			// select문이 아니기때문에 prepareStatement를 사용.
			pstmt = conn.prepareStatement(sql);

			// 바인딩 변수로 세팅
			pstmt.setString(1, num);

			// DB실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// DB해제
			DBManager.close(conn, pstmt);
		}

	}

	// DB조작 - 선택된 게시글을 읽어오는 메서드
	public Board selectOneBoardByNum(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;

		// sql문 셋팅
		String sql = "SELECT * FROM boardNotice WHERE num=?";

		try {

			// DB연결
			conn = DBManager.getConnection();

			// select문이지만 WHERE절이 있기 때문에 prepareStatement를 사용.
			pstmt = conn.prepareStatement(sql);
			// 바인딩 변수로 세팅
			pstmt.setString(1, num);
			// DB실행하여 ResultSet에 셋팅
			rs = pstmt.executeQuery();

			// ResultSet에 있는 모든 데이터를 한 줄 씩 읽음
			if (rs.next()) {
				// 값 저장 할 DTO 객체 생성
				board = new Board();

				// ResultSet으로 받아온 값을 DTO에 세팅
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setEmail(rs.getString("email"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// DB해제
			DBManager.close(conn, pstmt, rs);
		}

		return board;

	}

	// DB조작 - 게시글 수정하는 메서드
	public void updateBoard(Board board) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// sql문 셋팅
		String sql = "update boardNotice set name=?, email=?, title=?, content=? where num=?";

		try {

			// DB연결
			conn = DBManager.getConnection();

			// select문이 아니기때문에 prepareStatement를 사용.
			pstmt = conn.prepareStatement(sql);
			// 바인딩 변수로 세팅
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, board.getNum());

			// DB실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB해제
			DBManager.close(conn, pstmt);
		}

	}

	// DB조작 - 게시글을 삭제하는 메서드
	public void deleteBoardByNum(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// sql문 셋팅
		String sql = "DELETE boardNotice WHERE num=?";

		try {

			// DB연결
			conn = DBManager.getConnection();

			// select문이 아니기때문에 prepareStatement를 사용.
			pstmt = conn.prepareStatement(sql);
			// 바인딩 변수로 세팅
			pstmt.setString(1, num);
			// DB실행
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// DB해제
			DBManager.close(conn, pstmt);
		}
	}

	//등록 된 글의 갯수를 반환하는 메서드
	public int getAllCount() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(*) as count FROM boardNotice";

		int count = 0;

		try {
			conn = DBManager.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}

		return count;
	}

}
