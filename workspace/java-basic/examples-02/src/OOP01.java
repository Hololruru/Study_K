

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
		// TODO Auto-generated method stub

	}

}
