

// 연락처 관리 프로그램 만들기
// 1. 기능 : 연락처 등록, 연락처 목록 보기, 연락처 검색, 연락처 삭제, 연락처 수정
// 2. 실행방식 : 메뉴 제공 -> 메뉴 선택 -> 작업 실행
// 3. 모든 구현은 별도의 클래스를 만들어서 적용

class ContactManager {
	
	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public void doManage() { // 프로그램의 주 실행 로직 구현
		
		while (true) {
			
			String selection = selectMenu();
			
			System.out.println();
			if (selection.equals("1")) {
				
			} else if (selection.equals("4")) {
				
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
		// TODO Auto-generated method stub

	}

}
