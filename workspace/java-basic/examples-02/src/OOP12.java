

class TheParent {
	private String p;
	void m() {
		System.out.println("TheParent.m");
	}
	public TheParent() {
		System.out.println("TheParent's constructor");
	}
}

class TheChild extends TheParent { // TheParent 상속 : TheParent의 모든 멤버를 자동으로 포함
	
	// 상속 받는 클래스는 두 가지 중 한 가지는 포함
	// 1. 확장 : 새로운 멤버 변수 또는 메서드 추가
	// 2. 변경 : 기존 메서드 변경
	
	String c;
	void m2() {
		// p = "Parent's member"; // 오류 : 부모의 private 멤버는 사용할 수 없습니다.
		System.out.println("TheChild.m2");
	}
	public TheChild() {
		System.out.println("TheChild's constructor");
	}	
}

public class OOP12 {

	public static void main(String[] args) {
		
		// 1. 
		TheChild c1 = new TheChild(); // TheParent 생성 -> TheChild 생성
		c1.m(); // 상속받았기 때문에 TheParent의 멤버 m() 사용 가능
		c1.m2(); // 확장한 멤버 사용
		
		// 2. 참조타입과 인스턴스 타입이 다를 수 있습니다. ( 부모참조 -> 자식인스턴스 )
		TheParent p2 = new TheChild();
		
		// TheChild c2 = (TheChild)new TheParent(); // 허용되지 않습니다. ( 자식참조 -> 부모인스턴스 )
		TheChild c3 = (TheChild)p2; // 자식참조 -> 부모
		
		
		

	}

}
