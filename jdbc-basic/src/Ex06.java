import java.util.List;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		JobsDao dao = new JobsDao();
		
		//1. 신규 데이터 추가(insert)    - UI
		Job job = new Job();
		job.setJobid("DB_ADMIN");
		job.setJobtitle("Database Administrator");
		job.setMinsalary(8000);
		job.setMaxsalary(14000);
		
		dao.insertJob(job);
		System.out.println("신규 데이터를 저장했습니다.");
		// 결과는 SQL Developer를 사용해서 확인
		
//		// 1-1.추가된 데이터 조회 
		//select * from jobs where job_id = ?
		Job rjob = dao.selectJobById("DB_ADMIN");
		if (rjob == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rjob.toString());
		}
		
		//2. 기존 데이터 수정(update)
		//update jobs
		//set job_title= ?, Max_salary= ?
		//where job_id= ?
		Job job2 = new Job();
		job2.setJobid("DB_ADMIN"); // where 절에서 사용할 데이터
		job2.setJobtitle("Database Administrator 2"); //set 절에서 사용할 데이터
		job2.setMinsalary(7500); //set 절에서 사용할 데이터
		job2.setMaxsalary(13500); //set 절에서 사용할 데이터
		
		dao.updateJob(job2);
		System.out.println("데이터를 수정했습니다.");
		
		// 2-1.업데이트 확인 
		//select * from jobs where job_id = ?
		Job rjob2 = dao.selectJobById("DB_ADMIN");
		if (rjob2 == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rjob2.toString());
		}
		
		//3. 기존 데이터 삭제(delete)
		//Delete from jobs where job_id = ?
		String jobId= "DB_ADMIN";
		dao.deleteById(jobId);
		System.out.println("데이터를 삭제했습니다.");

		// 3-1.삭제확인
		//select * from jobs where job_id = ?
		Job rjob3 = dao.selectJobById("DB_ADMIN");
		if (rjob3 == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rjob3.toString());
		}
		
	}

}
