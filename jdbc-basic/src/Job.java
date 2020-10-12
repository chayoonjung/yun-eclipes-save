
/**이 클래스는 데이터베이스의 jobs 테이블의 데이터를 저장하기 위한 클래스
 * 
 * @author hoseo
 *
 */
public class Job {
	
	//이 클래스의 필드(변수)는 테이블의 컬럼과 일치하도록 구현
	private String jobid;
	private String jobtitle;
	private int minsalary;
	private int maxsalary;
	
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	
	public int getMinsalary() {
		return minsalary;
	}
	public void setMinsalary(int minsalary) {
		this.minsalary = minsalary;
	}
	public int getMaxsalary() {
		return maxsalary;
	}
	public void setMaxsalary(int maxsalary) {
		this.maxsalary = maxsalary;
	}
	//object 클래스에서 상속받은 메서드 : 객체의 정보를 간단한 문자열로 반환
	@Override
	public String toString() {
		return String.format("[%10s][%35s][%,6ds][%,6d]",
								jobid, jobtitle, minsalary, maxsalary);
		
	}
	
	
}















