

// 클래스 : 구현 대상의 문법적 표현, 설계도, 사용자 정의 자료형
// 클래스를 만드는 것으로는 어떤 실행도 발생하지 않습니다.
class Person {
	
	// 1. 특성
	int no;
	String name;
	String phone;
	String email;
	
	// 2. 기능
	String info() { // 연락처 정보 반환
		String info = "[" + no + "]" + 
				 	  "[" + name + "]" + 
				 	  "[" + phone + "]" + 
				 	  "[" + email + "]";
		// String.format : System.out.printf와 같은 기능 (출력 제외)
		String info2 = String.format("[%d][%s][%s][%s]", no, name, phone, email);
		return info2;  
	}
	
}

public class OOP01 {

	public static void main(String[] args) {
	
		// int a;
		Person person; // Person class 자료형으로 참조형 변수 만들기
		person = new Person(); // 데이터를 저장할 변수 만들기 + 그 변수의 주소를 person 변수에 저장

	}

}
