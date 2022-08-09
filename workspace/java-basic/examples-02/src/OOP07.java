

// 연락처 관리 프로그램 만들기
// 1. 기능 : 연락처 등록, 연락처 목록 보기, 연락처 검색, 연락처 삭제, 연락처 수정
// 2. 실행방식 : 메뉴 제공 -> 메뉴 선택 -> 작업 실행
// 3. 모든 구현은 별도의 클래스를 만들어서 적용

// 연락처 정보 저장용 클래스
class Contact {
	private int no;		 
	private String name;
	private String phone;
	private String email;

	public Contact() {}
	public Contact(int no, String name, String phone, String email) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String info() {
		return String.format("[%d][%s][%s][%s]", no, name, phone, email);
	}
}

// 연락처 관리 기능 클래스
class ContactManager {
	
	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	private Contact[] contacts = new Contact[1000]; // 연락처 목록 변수
	private int nextIdx = 0; // 새로 등록되는 연락처가 저장될 배열의 위치
	
	public void doManage() { // 프로그램의 주 실행 로직 구현
		
		while (true) {
			
			String selection = selectMenu();
			
			System.out.println();
			if (selection.equals("1")) {
				// 등록 기능 구현
				// 1. Contact 인스턴스 만들기
				Contact contact = new Contact();
				// 2. 사용자 입력 -> 입력된 내용을 Contact 인스턴스에 저장
				contact.setNo(nextIdx + 1);
				System.out.print("이름 : ");
				String name = scanner.next();
				contact.setName(name); // contact.name = name;
				System.out.print("전화번호 : ");
				String phone = scanner.next();
				contact.setPhone(phone);
				System.out.print("이메일 : ");
				String email = scanner.next();
				contact.setEmail(email);
				// 3. 2의 인스턴스를 conatcts 배열에 저장 ( nextIdx를 사용해서 위치 결정 )
				contacts[nextIdx] = contact;
				// 4. 다음 연락처의 저장 위치를 하나 증가 
				nextIdx++;
			} else if (selection.equals("4")) { // 전체 목록 보기
				// contacts 배열의 데이터를 처음(0)부터 데이터가 저장된 위치(nextIdx)까지 반복하면서 출력
				System.out.println("[ 연락처 목록 ]");
				for (int i = 0; i < nextIdx; i++) {
					System.out.println(contacts[i].info());
				}
			} else if (selection.equals("9")) {
				System.out.println("$$$ 연락처 관리 프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("$$$ 지원하지 않는 기능입니다.");
			}
			System.out.println();
		}
		
	}
	
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
	
	
	
}

public class OOP07 {

	public static void main(String[] args) {
		
		ContactManager manager = new ContactManager();
		manager.doManage();

	}

}
