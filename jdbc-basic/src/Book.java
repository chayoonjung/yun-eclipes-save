import java.util.ArrayList;

/**이 클래스는 데이터베이스의 jobs 테이블의 데이터를 저장하기 위한 클래스
 * 
 * @author hoseo
 *
 */
public class Book {
	
	//이 클래스의 필드(변수)는 테이블의 컬럼과 일치하도록 구현
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String toString() {
		return String.format("[%4s][%10s][%10s][%,6d]",
							bookid, bookname, publisher, price);
		
		
	}
	
	

		
	
	
	
}















