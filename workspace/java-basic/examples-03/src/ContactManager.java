import java.util.ArrayList;

// 연락처 관리 기능 클래스
class ContactManager {
	
	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	// private Contact[] contacts = new Contact[1000]; // 연락처 목록 변수
	// private int nextIdx = 0; // 새로 등록되는 연락처가 저장될 배열의 위치	
	private ArrayList<Contact> contacts = new ArrayList<>();
	
	public void doManage() { // 프로그램의 주 실행 로직 구현
		
		while (true) {
			
			String selection = selectMenu();
			
			System.out.println();
			if (selection.equals("1")) { // 등록
				// 등록 기능 구현				
				Contact contact = inputContact();
				
				// 3. 2의 인스턴스를 conatcts 배열에 저장 ( nextIdx를 사용해서 위치 결정 )
				contacts[nextIdx] = contact;
				// 4. 다음 연락처의 저장 위치를 하나 증가 
				nextIdx++;
				
				System.out.println("$$$ 새 연락처를 등록했습니다");
				
			} else if (selection.equals("4")) { // 전체 목록 보기
				
				showAllContacts();
				
			} else if (selection.equals("5")) { // 검색
				//1. 검색할 이름 입력
				System.out.print("검색할 이름 : ");
				String name = scanner.next();
				
				showSearchedContacts(name);
				
			} else if (selection.equals("9")) {
				System.out.println("$$$ 연락처 관리 프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("$$$ 지원하지 않는 기능입니다.");
			}
			System.out.println();
		}		
	}
	
	public void showSearchedContacts(String name) {
		//2. 연락처 목록을 0 ~ nextIdx까지 반복하면서 이름이 같은 연락처 찾기 -> 출력
		//   --> 입력 받은 이름과 연락처.getName()과 비교 ( == 사용하면 안되고, equals를 사용해서 비교 )
		//       if (search.equals( contacts[i].getName() )				
		System.out.println("[ 검색된 연락처 목록 ]");
		for (int i = 0; i < nextIdx; i++) {
			// if (name.equals(contacts[i].getName())) { 	// 완전 일치 검색 -> equals 사용
			if (contacts[i].getName().contains(name)) { 	// 부분 일치 검색 -> contains 사용
				System.out.println(contacts[i].info());
			}
		}
	}
	
	public void showAllContacts() {
		// contacts 배열의 데이터를 처음(0)부터 데이터가 저장된 위치(nextIdx)까지 반복하면서 출력
		System.out.println("[ 연락처 목록 ]");
		for (int i = 0; i < nextIdx; i++) {
			System.out.println(contacts[i].info());
		}
	}

	public Contact inputContact() {
		// 1. Contact 인스턴스 만들기
		Contact contact = new Contact();
		// 2. 사용자 입력 -> 입력된 내용을 Contact 인스턴스에 저장
		System.out.println("[ 신규 등록 연락처 정보 입력 ]");
		int cnt = contacts.size(); // 연락처 갯수
		contact.setNo(cnt + 1); // 마지막 연락처의 다음 순서 번호 사용
		System.out.print("이름 : ");
		String name = scanner.next();
		contact.setName(name); // contact.name = name;
		System.out.print("전화번호 : ");
		String phone = scanner.next();
		contact.setPhone(phone);
		System.out.print("이메일 : ");
		String email = scanner.next();
		contact.setEmail(email);
		
		return contact;
	}
	
	/**
	 * 사용자에게 선택 가능한 기능 목록을 표시하고<br />
	 * 사용자의 선택을 입력받은 후 반환
	 * 
	 * @return 문자열 형식의 사용자 입력 값
	 */
	String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 연락처 등록                 *");
		System.out.println("* 2. 연락처 수정                 *");
		System.out.println("* 3. 연락처 삭제                 *");
		System.out.println("* 4. 연락처 목록                 *");
		System.out.println("* 5. 연락처 검색                 *");
		System.out.println("* 9. 종료                      *");
		System.out.println("******************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.next();
		
		return selection;
	}
	
	
	public static void main(String[] args) {
		
		ContactManager contactManager = new ContactManager();
		
		contactManager.doManage();
		
	}
}










