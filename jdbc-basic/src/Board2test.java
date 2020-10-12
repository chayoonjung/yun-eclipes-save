import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import oracle.jdbc.OracleDriver;

public class Board2test {

	public static void main(String[] args) {
		int num=2;
		String title="두 번째 게시글";
		String writer="iamuserone";
		String content="JDBC를 사용해서 작성한 글입니다.";
		
		insertBoard3(num, title, writer, content);

	}
	public static void insertBoard3(int num, String title, String writer, String content ) {
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
									
		//데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
						
			//1. JDBC 드라이버 준비(로딩)
			DriverManager.registerDriver(new OracleDriver());
						
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
						"hoseo","hoseo"); //계정정보(id, password)
						
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "insert into Board3 " +
						"(num, title, writer, content) " +
						"Values (?, ?, ?, ?) "; 
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num); //SQL의 1번째 ?에 salary 변수의 값을 대입				pstmt.setString(2, job.getJobtitle());
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setString(4, content);
						
						
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			pstmt.executeUpdate();
			 			
			//5. 결과 처리(결과가 있을 경우, select인 경우)
			//	do nothing
						
			} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
						
				ex.printStackTrace(); //오류 메세지를 화면에 출력
						
			} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기(종료)
					
			try { pstmt.close();} catch (Exception ex) {}
			try { conn.close();} catch (Exception ex) {}
		}		
	}

}
