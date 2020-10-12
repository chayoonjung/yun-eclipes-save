package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demoweb.vo.MemberVO;

import oracle.jdbc.OracleDriver;

public class MemberDao {
	
	public MemberVO selectMemberByIdAndPasswd(String id, String passwd) {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
				
		MemberVO member = null; //조회 결과 목록을 저장할 변수
		
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
			String sql = "select MEMBERID, EMAIL, USERTYPE, REGDATE, ACTIVE " +
						 "from MEMBER " +
						 "where MEMBERID = ? AND PASSWD = ? "; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
		 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
					
			//while 말고 if도 사용가능. (PK 조건) 결과가 1개밖에 없기 때문에 궂이 반복문 사용 안해도 된다.
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환) 					
				member = new MemberVO(); // 한 행(Row)은 member 객체 1개와 일치
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setRegDate(rs.getDate(4));
				member.setActive(rs.getBoolean(5));
						
				}
					
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
					
					ex.printStackTrace(); //오류 메세지를 화면에 출력
					
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
				//6. 연결 닫기(종료)
				try { rs.close();} catch (Exception ex) {}
				try { pstmt.close();} catch (Exception ex) {}
				try { conn.close();} catch (Exception ex) {}
			}
				
			return member; //조회 결과를 호출한 곳으로 반환
			}

	public void insertMember(MemberVO member) {
		
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
			String sql = "insert into member(MEMBERID, PASSWD ,EMAIL)" +						 
						 "values(?, ?, ?) ";			 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			
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
