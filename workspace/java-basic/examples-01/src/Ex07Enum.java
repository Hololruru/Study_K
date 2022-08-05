
// MALE, FEMALE 두 개의 값만 저장할 수 있는 자료형 만들기 ( 사용자 정의 자료형 )
enum Gender {
	MALE,	// 열거 상수
	FEMALE
}

enum RainbowColor {
	RED,
	ORANGE,
	YELLOW,
	GREEN,
	BLUE,
	NAVY,
	PURPLE
}

public class Ex07Enum {

	public static void main(String[] args) {
		
		Gender gender; // gender 변수에는 MALE, FEMALE만 저장 가능
		gender = Gender.MALE;
		System.out.println(gender);
		
		RainbowColor color;
		// color = Gender.MALE;
		color = RainbowColor.PURPLE;
		System.out.println(color);

	}

}
