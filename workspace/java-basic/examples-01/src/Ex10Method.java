
public class Ex10Method {

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
//		System.out.print("박스의 너비 : ");
//		int width = scanner.nextInt();
//		System.out.print("박스의 높이 : ");
//		int height = scanner.nextInt();
		
		// 메서드 호출 : 정의된 메서드를 불러서 메서드 내부의 코드가 실행되도록 하는 작업
		drawBox();
		drawBox();
		
		scanner.close();

	}

	// 메서드 정의, 메서드 만들기 -> 메서드를 만드는 것이 메서드의 코드를 실행하는 것은 아닙니다.
	private static void drawBox() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 30; x++) {
				if (x == 0 || y == 0 || 
					x == 30 - 1 || y == 10 - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
