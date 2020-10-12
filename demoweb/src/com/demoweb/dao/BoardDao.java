package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demoweb.vo.BoardVO;
import com.demoweb.vo.MemberVO;

import oracle.jdbc.OracleDriver;

public class BoardDao {

	public void insertBoard(BoardVO board) {
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "insert into board(boardno, title , writer, content)" +						 
						 "values(boardno_seq.nextval, ?, ?, ?) ";			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			//4. 명령 실행(insert, update, delete 등인 경우)
			pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
			
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
		
	}

	public List<BoardVO> selectAllBoard() {
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
				
		ArrayList<BoardVO> boards = new ArrayList<>(); //조회 결과 목록을 저장할 변수
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select boardno, title, writer, readcount, regdate, deleted " +
						 "from board " +
						 "order by boardno desc ";
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
					
			//while 말고 if도 사용가능. (PK 조건) 결과가 1개밖에 없기 때문에 궂이 반복문 사용 안해도 된다.
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환) 					
				BoardVO board = new BoardVO(); // 한 행(Row)은 member 객체 1개와 일치
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				board.setRegDate(rs.getDate(5));
				board.setDeleted(rs.getBoolean(6));

				boards.add(board); // 한 행의 데이터를 목록에 추가
				}
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { rs.close();} catch (Exception ex) {}
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
				
			return boards; //조회 결과를 호출한 곳으로 반환
			
	}
	public List<BoardVO> selectBoardsWithPaging(int from, int to) {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
				
		ArrayList<BoardVO> boards = new ArrayList<>(); //조회 결과 목록을 저장할 변수
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select boardno, title, writer, readcount, regdate, deleted " +
						 "from " +
						 "( " +
						 "select rownum idx, A.* " +
						 "from " +
						 "( " +
					     " select * " + 
					     " from Board " + 
					     " order by boardNo desc " +
					     " ) A " +
					     ") " +
					     "where idx >=? and idx <? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, from);
			pstmt.setInt(2, to);
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
					
			//while 말고 if도 사용가능. (PK 조건) 결과가 1개밖에 없기 때문에 궂이 반복문 사용 안해도 된다.
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환) 					
				BoardVO board = new BoardVO(); // 한 행(Row)은 member 객체 1개와 일치
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				board.setRegDate(rs.getDate(5));
				board.setDeleted(rs.getBoolean(6));

				boards.add(board); // 한 행의 데이터를 목록에 추가
				}
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { rs.close();} catch (Exception ex) {}
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
				
			return boards; //조회 결과를 호출한 곳으로 반환
			
	}
	// 게시물 전체 몇개인지 알려주는 코드
	public int selectBoardCount() {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
				
		int count = 0;
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select count(*) from board ";
						 
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
					
			//while 말고 if도 사용가능. (PK 조건) 결과가 1개밖에 없기 때문에 궂이 반복문 사용 안해도 된다.
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환) 					
				count = rs.getInt(1);
				}
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { rs.close();} catch (Exception ex) {}
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
				
			return count; //조회 결과를 호출한 곳으로 반환
		}
	

	public BoardVO selectBoardByBoardNo(int boardNo) {
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
				
		BoardVO board = null; //하나만 조회하는 것이기 때문에 있느냐 없느냐
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select boardno, title, writer, content, readcount, regdate " +
						 "from board " +
						 "where boardNo = ? and deleted = '0' "; //삭제 되지 않은애만 조회
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);   
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 		
			//while 말고 if도 사용가능. (PK 조건) 결과가 1개밖에 없기 때문에 궂이 반복문 사용 안해도 된다.
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환) 					
				board = new BoardVO(); // 한 행(Row)은 member 객체 1개와 일치
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setReadCount(rs.getInt(5));
				board.setRegDate(rs.getDate(6));
				}
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { rs.close();} catch (Exception ex) {}
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
				
			return board; //조회 결과를 호출한 곳으로 반환
	}

	public static void updateReadCount(int boardNo, int i) {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "update board " +			
						 "set readcount = readcount + 1 " +
						 "where boardNo = ? ";			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			
			//4. 명령 실행(insert, update, delete 등인 경우)
			pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
			
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}

	}

	public void updateDeleteFlag(int boardNo) {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "update board " +			
						 "set deleted = '1' " +
						 "where boardNo = ? ";			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			
			//4. 명령 실행(insert, update, delete 등인 경우)
			pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
			
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
		
	}

	public static void updateBoard(BoardVO b) {
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
					
			//1. JDBC 드라이버 준비(로딩) // (lib폴더에 ojdbc6.jar 넣음. )
			DriverManager.registerDriver(new OracleDriver());
					
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"demoweb","hoseo"); //계정정보(id, password)
					
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "update board " +			
						 "set title = ?, content =? " +
						 "where boardNo = ? ";			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getBoardNo());
			
			
			//4. 명령 실행(insert, update, delete 등인 경우)
			pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
			
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
		
	}

}
