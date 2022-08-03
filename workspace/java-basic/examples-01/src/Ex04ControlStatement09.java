
public class Ex04ControlStatement09 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// 1-1. box 그리기 ( 크기는 : 20 x 10 또는 사용자 입력 )
		//      ********************
		//      ********************
		//      ********************
		//      ....
		//      ********************		
		// 1-2. box 그리기 ( 크기는 : 20 x 10 또는 사용자 입력 )
		//      ********************
		//      *                  *
		//      *                  *
		//      ....
		//      ********************
		System.out.print("박스의 너비 : ");
		int width = scanner.nextInt();
		System.out.print("박스의 높이 : ");
		int height = scanner.nextInt();
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
