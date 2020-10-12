import java.util.List;
import java.util.Scanner;

public class Ex06_1 {

	public static void main(String[] args) {
		
		BookDao dao = new BookDao();
		
		//1. 신규 데이터 추가(insert)    - UI
		Book book = new Book();
		book.setBookid(30);
		book.setBookname("통계학 이론");
		book.setPublisher("수학사");
		book.setPrice(30000);
		
		dao.insertBook(book);
		System.out.println("신규 데이터를 저장했습니다.");
		// 결과는 SQL Developer를 사용해서 확인
		
//		// 1-1.추가된 데이터 조회 
		//select * from jobs where job_id = ?
		Book rbook = dao.selectBookById(30);
		if (rbook == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rbook.toString());
		}
		
		//2. 기존 데이터 수정(update)
		//update jobs
		//set job_title= ?, Max_salary= ?
		//where job_id= ?
		Book book2 = new Book();
		book.setBookid(30);
		book.setBookname("통계학 이론");
		book.setPublisher("수학사");
		book.setPrice(30000);
		
		dao.updateBook(book2);
		System.out.println("데이터를 수정했습니다.");
		
		// 2-1.업데이트 확인 
		//select * from jobs where job_id = ?
		Book rbook2 = dao.selectBookById(30);
		if (rbook2 == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rbook2.toString());
		}
		
		//3. 기존 데이터 삭제(delete)
		//Delete from jobs where job_id = ?
		int bookId= 30;
		dao.deleteBookById(bookId);
		System.out.println("데이터를 사제했습니다.");

		// 3-1.삭제확인
		//select * from jobs where job_id = ?
		Book rbook3 = dao.selectBookById(30);
		if (rbook3 == null) {
			System.out.println("데이터가 없습니다.");
		} else {
			System.out.println(rbook3.toString());
		}
		
	}

}
