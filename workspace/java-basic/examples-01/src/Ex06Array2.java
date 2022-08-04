
public class Ex06Array2 {

	public static void main(String[] args) {
		
		// [ 로또 번호 추출기 만들기 ]
		// 1. 정수 6개를 저장하는 배열 만들기
		// 2. 1 ~ 45 범위의 난수 6개 뽑아서 배열 변수에 저장
		// 3. 뽑힌 숫자의 평균 구해서 변수에 저장
		// 4. 뽑힌 숫자와 평균 출력하기
		// ==============================
		// 5. 중복이 발생하지 않도록 숫자 뽑기
		// 6. 메뉴 사용해서 사용자가 원하는 동안 반복
		
		int[] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
		}
		
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i]; // sum = sum + numbers[i];
		}
		int average = sum / numbers.length;
		
		System.out.print("선택된 번호 : ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("[%2d]", numbers[i]);
		}
		System.out.printf("[AVERAGE : %2d]\n", average);

	}

}
