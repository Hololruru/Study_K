
public class Ex04ControlStatement02 {

	public static void main(String[] args) {
		
		// 1-1. 난수 발생기 사용
		double number = Math.random(); // Math.random() : 0 <= n < 1 범위의 난수 발생
		System.out.println("난수 1 : " + number);
		
		// 1-2. 1 ~ 100 범위의 정수형 난수 만들기
		double number2 = Math.random() * 99; // 0 ~ 99 (실수)
		number2 = number2 + 1; // 1 ~ 100 (실수)
		int iNumber = (int)number2;
		System.out.println("난수 2 : " + iNumber);
		
		
		

	}

}
