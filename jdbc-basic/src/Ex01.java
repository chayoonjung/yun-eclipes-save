import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleDriver;

// 자바의 예외 두종류 
//1.checked exception : 반드시 예외 처리 필요
//2. runtime exception : 선택적 예외 처리 

public class Ex01 {

	public static void main(String[] args) {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
		
	  //데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception)
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
			
			//1. JDBC 드라이버 준비(로딩)
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"hr","hoseo"); //계정정보(id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select first_name, last_name, email " +
						 "from employees ";
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
 			
			//5. 결과 처리(결과가 있을 경우, select인 경우)
			while(rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환)
				System.out.printf("[%s][%s][%s]\n",
						rs.getString(1),rs.getString(2),rs.getString(3));
			}//jdbc 에서는 1번부터로 진행 
			
		} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
			
			ex.printStackTrace(); //오류 메세지를 화면에 출력
			
		} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기(종료)
			try { rs.close();} catch (Exception ex) {}
			try { pstmt.close();} catch (Exception ex) {}
			try { conn.close();} catch (Exception ex) {}
		}

	}

}
