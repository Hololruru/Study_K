
public class Ex04ControlStatement07 {

	public static void main(String[] args) {
		
		// 1 ~ 10까지 정수를 순차적으로 출력
		int round = 1;
		while ( round <= 10 ) {
			// System.out.printf("[%02d] 라운드입니다.\n", round); // %02d : 두자리에 출력, 앞자리가 비면 0으로 채우기
			System.out.printf("[%2d] 라운드입니다.\n", round); // %2d : 두자리에 출력
			round++; // ==> round += 1;  ==> round = round + 1;
		}
		
		// 1 ~ 사용자가 입력한 숫자까지 정수의 합 계산
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.print("1보다 큰 정수 입력 : ");
		int number = scanner.nextInt();
		int idx = 1;
		int sum = 0;
		while (idx <= number) {
			sum = sum + idx;
			idx++;
		}
		
		System.out.printf("%d ~ %d까지의 합 : %d\n", 1, number, sum);
		
		
		
		scanner.close();

	}

}
