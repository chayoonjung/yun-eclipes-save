import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 연락처를 관리하는 클래스<br>
 * 배열을 사용해서 연락처 목록 저장<br>
 * 등록, 목록보기, 검색, 삭제, 수정기능 구현
 * 
 * @author hoseo
 *
 */
public class ContactManager3 {
	
	private ContactDao dao = new ContactDao();
	
	
	// 연락처 관리기능 구현한 메서드
	public void doManage() {
		
		outer: while (true) { //끝날 때까지 반복
			
			// 1. 메뉴 표시 및 사용자 입력
			String selection = selectMenu();
			
			// 2. 사용자 선택에 따라 작업 수행( 등록, 목록보기, ....)
			switch (selection) { // selection = 변수
			case "0": // "0" = 값
				System.out.println("프로그램을 종료합니다.");
				break outer; //outer로 이름 붙인 반복문 또는 선택문을 break하는 것.
			case "1": // "0" = 값  // 연락처 등록을 선택한 경우
				
				createNewContact();
				break; 
				
			case "2": // 목록 표시 
				showAllContacts();
				break;
			case "3": // 검색
				searchContact();						
				break;
			case "4": // 삭제 
				deleteContact();				
				break;
				
			case "5": break;
			
			default: 
				System.out.println("지원하지 않는 작업입니다.");
				break; // break는 가장 가까운 반복문 또는 선택문 break
			}
		
		}	
	
		
	}

	private void deleteContact() {
		// 1. 검색
		List<Contact> results2 = findContact();
		if (results2.size() == 0) {
			System.out.println("검색된 연락처가 없습니다.");
			return;
		} else {
			System.out.println("[검색된 연락처]");
			for (Contact c: results2) {
				System.out.println(c.toString());
			}
		}
		// 2. 삭제할 연락처 선택(입력)
		System.out.println("삭제할 연락처 번호: ");
		int no = scanner.nextInt(); 
		scanner.nextLine(); // buffer에 남아 있는 enter 제거
		// 3. 삭제 (리스트를 순회하면서 번호가 같은 연락처 제거)
		dao.deleteContact(no);
	}

	private void searchContact() {
		List<Contact> results = findContact();
		if (results.size() == 0) {
			System.out.println("검색된 연락처가 없습니다.");
		} else {
			System.out.println("[검색된 연락처]");
			for (Contact c: results) {
				System.out.println(c.toString());
			}
		}
	}

	Scanner scanner = new Scanner(System.in);
	
	private String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 연락처 등록                              *");
		System.out.println("* 2. 연락처 목록                              *");
		System.out.println("* 3. 연락처 검색                              *");
		System.out.println("* 4. 연락처 삭제                              *");
		System.out.println("* 5. 연락처 수정                              *");
		System.out.println("* 0. 종료                                       *");
		System.out.println("******************************");
		System.out.print("원하는 작업 번호를 입력하세요 : ");
		String selection = scanner.nextLine();
		return selection;
	}
	
	private void createNewContact() {
		System.out.println("[등록할 연락처 정보]");
		System.out.println("이름을 입력하세요: ");
		String name = scanner.nextLine();
		System.out.println("전화번호를 입력하세요: ");
		String phone = scanner.nextLine();
		System.out.println("이메일 입력하세요: ");
		String email = scanner.nextLine();
		
		Contact c = new Contact();
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);
		
		dao.insertContact(c);    //데이터 저장

	}
	
	private void showAllContacts() {
		
		List<Contact> contacts = dao.selectContacts();
		
		if (contacts.size() == 0) {         
			System.out.println("등록된 연락처가 없습니다.");
			return;
		}
		
		System.out.println("[연락처 목록]");
		for (Contact c : contacts) {
			String info = c.toString();
			System.out.println(info);
		}
			
	}
	
	private List<Contact> findContact() {
		// 1. 이름 입력
		System.out.print("검색할 이름을 입력하세요: ");
		String name = scanner.nextLine();
		
		// 2. 배열에 저장된 연락처를 순회하면서 입력된 이름과 비교
		List<Contact> results = dao.selectContactsByName(name);

				return results;
				
			}
	}
	

