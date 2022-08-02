
public class Ex04ControlStatement08 {

	public static void main(String[] args) {
		
		// 1 ~ 10까지 출력
//		for (int i = 1; i <= 10; i++) { // i++ ==> i += 1 ==> i = i + 1		
//			System.out.printf("이번 회차는 %d입니다.\n", i);
//		}
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// 1 ~ 사용자가 입력한 숫자까지의 합
//		System.out.print("숫자를 입력하세요 : ");
//		int number = scanner.nextInt();
//		int sum = 0;
//		for (int i = 1; i <= number; i++) {
//			sum += i; // sum = sum + i;
//		}
//		System.out.printf("%d ~ %d까지의 합 : %d\n", 1, number, sum);
		
		// 명명된 반복문 break
		outer: for (int i = 0; i < 5 ; i++) {
			inner: for (int j = 0; j < 5; j++) {
				System.out.printf("[%d][%d]\n", i, j);
				if (j == 2) {
					//break; // j 반복문 (내부 반복문) break;
					break outer; // outer 이름이 붙은 반복문 break
				}
			}
		}

		
		scanner.close();
	}

}
