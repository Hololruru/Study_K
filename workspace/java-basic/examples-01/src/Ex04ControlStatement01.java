
public class Ex04ControlStatement01 {

	public static void main(String[] args) {
		
		//1. if statement
		boolean b = true;
		// boolean b = false;
		
		if (b) {
			System.out.println("선택적 문장 실행 1"); // b가 true인 경우에만 실행
			System.out.println("선택적 문장 실행 2"); // b가 true인 경우에만 실행
		}
		
		System.out.println("항상 실행되는 문장 실행");
		
		//2. 사용자입력 (숫자) -> 0보다 크면 "큽니다" 출력,  0보다 작으면 "작습니다" 출력, 0이면 "0입니다" 출력
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int number = scanner.nextInt();
		
		if (number > 0) { // number > 0 : number가 0보다 크면 true, 아니면 false
			System.out.println("0보다 큰 숫자입니다.");
		} else if (number < 0){ 
			System.out.println("0보다 작은 숫자입니다.");
		} else if (number == 0) {
			System.out.println("0입니다.");
		}
		
		scanner.close(); // Scanner는 다 사용하면 닫아야 합니다. ( 반납 )
		

	}

}
