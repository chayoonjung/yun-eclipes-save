import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

/**
 * 데이터베이스 연동을 구현하는 클래스<br>
 * Jobs 테이블 대상으로 하는 JDBC 로직 구현
 * @author hoseo
 *
 */
public class JobsDao {

//	public ArrayList<Job> selectJobsByMaxSalary(int salary) {
	public List<Job> selectJobsByMaxSalary(int salary) {
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
		
		ArrayList<Job> jobs = new ArrayList<>(); //조회결과를 저장할 리스트
		
	  //데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
			
			//1. JDBC 드라이버 준비(로딩)
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"hr","hoseo"); //계정정보(id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select job_id, job_title, min_salary, max_salary " +
						 "from jobs " +
//						 "where max_salary >= " + salary;
						 "where max_salary >= ? "; 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salary); //SQL의 1번째 ?에 salary 변수의 값을 대입
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
 			
			//5. 결과 처리(결과가 있을 경우, select인 경우)
			while(rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환)
//				System.out.printf("[%10s][%35s][%,6d][%,6d]\n",
//						rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				Job job = new Job(); // 한 행(Row)은 job 객체 1개와 일치
				job.setJobid(rs.getString(1));
				job.setJobtitle(rs.getString(2));
				job.setMinsalary(rs.getInt(3));
				job.setMaxsalary(rs.getInt(4));
				
				jobs.add(job); // 한 행의 데이터를 저장한 객체를 리스트에 추가
			}//jdbc 에서는 1번부터로 진행 
			
		} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
			
			ex.printStackTrace(); //오류 메세지를 화면에 출력
			
		} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기(종료)
			try { rs.close();} catch (Exception ex) {}
			try { pstmt.close();} catch (Exception ex) {}
			try { conn.close();} catch (Exception ex) {}
		}
		
		return jobs; //조회 결과를 호출한 곳으로 반환
		
	}
	
	//public List<Job> selectJobsById(String jobId) // 결과가 여러개
	public Job selectJobById(String jobId) { // 결과가 1개 (PK 조건)
		
		// 데이터베이스 연동에 사용되는 객체(변수 선언)
		Connection conn = null; //연결 관리
		PreparedStatement pstmt = null; // 명령 처리
		ResultSet rs = null; // 경과 집합 접근 (cursor)
		
		Job job = null; //조회결과를 저장할 리스트
		
	  //데이터베이스 연동에서 발생하는 예외는 반드시 예외처리 필요(checked exception) - 데이터 로직
		try {// 예외 발생이 의심되는 영역 (여기서 발생한 예외만 catch가능)
			
			//1. JDBC 드라이버 준비(로딩)
			DriverManager.registerDriver(new OracleDriver());
			
			//2. 연결(연결 객체 만들기)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", // 서버연결정보
					"hr","hoseo"); //계정정보(id, password)
			
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "select job_id, job_title, min_salary, max_salary " +
						 "from jobs " +
//						 "where max_salary >= " + salary;
						 "where job_Id = ? "; 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobId); //SQL의 1번째 ?에 salary 변수의 값을 대입
			
			//4. 명령 실행+ 결과집합 저장 (select인 경우)
			rs = pstmt.executeQuery();
 			
			//5. 결과 처리(결과가 있을 경우, select인 경우) 
			
			//while 말고 if도 사용가능. (PK 조건) 결과가 1개밖에 없기 때문에 궂이 반복문 사용 안해도 된다.
			while (rs.next()) { // next() : 결과 집합의 다음 행으로 이동(데이터가 없으면 false 반환) 
//				System.out.printf("[%10s][%35s][%,6d][%,6d]\n",
//						rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				job = new Job(); // 한 행(Row)은 job 객체 1개와 일치
				job.setJobid(rs.getString(1));
				job.setJobtitle(rs.getString(2));
				job.setMinsalary(rs.getInt(3));
				job.setMaxsalary(rs.getInt(4));
				
			}//jdbc 에서는 1번부터로 진행 
			
		} catch (Exception ex) { //예외 발생이 일어나면 실행되는 영역
			
			ex.printStackTrace(); //오류 메세지를 화면에 출력
			
		} finally { // 예외발생 여부와 상관없이 항상 실행되는 영역
			//6. 연결 닫기(종료)
			try { rs.close();} catch (Exception ex) {}
			try { pstmt.close();} catch (Exception ex) {}
			try { conn.close();} catch (Exception ex) {}
		}
		
		return job; //조회 결과를 호출한 곳으로 반환
	}

	public void insertJob(Job job) {
		
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
						"hr","hoseo"); //계정정보(id, password)
					
				//3. SQL 작성 + 명령 객체 만들기
				// email 뒤에 꼭 띄어쓰기 해야함.
				String sql = "insert into Jobs " +
							"(job_id,job_title, max_salary, min_salary) " +
							"Values (?, ?, ?, ?) "; 
					
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, job.getJobid()); //SQL의 1번째 ?에 salary 변수의 값을 대입
				pstmt.setString(2, job.getJobtitle());
				pstmt.setInt(3, job.getMaxsalary());
				pstmt.setInt(4, job.getMinsalary());
					
					
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

	public void updateJob(Job job) {
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
					"hr","hoseo"); //계정정보(id, password)
				
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "UPDATE JOBS " +
						 "set job_title=?, max_salary=?, min_salary=? " +
						 "where job_id=? "; 
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, job.getJobid()); //SQL의 4번째 ?에 salary 변수의 값을 대입
			pstmt.setString(1, job.getJobtitle());
			pstmt.setInt(2, job.getMaxsalary());
			pstmt.setInt(3, job.getMinsalary());
				
				
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

	public void deleteById(String jobId) {
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
					"hr","hoseo"); //계정정보(id, password)
				
			//3. SQL 작성 + 명령 객체 만들기
			// email 뒤에 꼭 띄어쓰기 해야함.
			String sql = "DELETE FROM JOBS " +
						 "where job_id=? "; 
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobId); //SQL의 1번째 ?에 salary 변수의 값을 대입
			
				
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
