import java.util.List;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		//Scanner : 명령행에서 사용자 입력 처리하는 도구 - UI
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 기준 급여: ");
		int salary = scanner.nextInt();
		
		JobsDao dao = new JobsDao();
		List<Job> jobs = dao.selectJobsByMaxSalary(salary);
		
		
		// 조회된 데이터 출력 -UI
		for (Job job : jobs) {
			System.out.println(job.toString());
		}
		
		scanner.close();

	}

}
