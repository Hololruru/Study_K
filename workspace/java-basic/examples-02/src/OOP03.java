

// 클래스 : 구현 대상의 문법적 표현, 설계도, 사용자 정의 자료형
// 클래스를 만드는 것으로는 어떤 실행도 발생하지 않습니다.
class Person3 {	
	// 1. 특성
	public int publicNo;
	private int no;				 // 변수이름 -> get or set + 첫번째문자(대문자) + 나머지변수이름
	private String name;
	private String phone;
	private String email;
	
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

	// 2. 기능
	public String info() { // 연락처 정보 반환
		String info2 = String.format("[%d][%s][%s][%s]", no, name, phone, email);
		return info2;  
	}	
}
public class OOP03 {
	
	public static void main(String[] args) {
		
		Person3 person = new Person3();
		person.publicNo = 1; 	// public 멤버는 외부에서 접근 가능
		//person.no = 1; 		// private 멤버는 외부 접근 허용 X
		person.setNo(1);		// person.no = 1 과 같은 효과
		person.setName("톰크루즈");// person.name = "톰크루즈"와 같은 효과
		person.setPhone("010-9456-2208");
		person.setEmail("tom@example.com");
		
		System.out.println(person.info());
		

	}

}










