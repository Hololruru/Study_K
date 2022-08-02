
public class Ex04ControlStatement03 {

	public static void main(String[] args) {
		
		// [ 점수 계산기 만들기 ]
		// 1. 점수 3개 입력 (0 ~ 100) 받아서 변수(score1, score2, score3)에 저장
		//    테스트 코드
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("첫 번째 점수 : ");
		int score1 = scanner.nextInt();
		System.out.print("두 번째 점수 : ");
		int score2 = scanner.nextInt();
		System.out.print("세 번째 점수 : ");
		int score3 = scanner.nextInt();
		System.out.printf("[%d][%d][%d]\n", score1, score2, score3);
		
		// 2. 합계와 평균을 계산해서 변수(total, average)에 저장
		//    테스트 코드
		int total = score1 + score2 + score3;
		double average = total / 3.; // 3. ==> 3.0
		System.out.printf("[TOTAL : %d][AVERAGE : %.2f]", total, average);		
		
		
		// 3. 평균에 따라 등급 계산해서 변수(grade)에 저장
		//    ( 90~100 : A, 80~89 : B, 70~79 : C, 60~69 : D, 나머지 : F )
		
		// 4. 출력
		
		scanner.close();

	}

}
