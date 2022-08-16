import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//JFrame : 자바의 윈도우 구현 클래스
public class ThreadDemoFrame extends JFrame {
	
	public ThreadDemoFrame() {// 생성자 메서드 : 초기화, 클래스 이름과 동일, 결과형 없음
		
		setTitle("쓰레드 테스트 윈도우");
		// 윈도우를 닫으면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 800);
		setLayout(null); // 하위 요소의 위치와 크기를 직접 설정
		setResizable(false); // 윈도우 크기 변경 차단
		
		JButton button1 = new JButton();
		button1.setText("GUI 버튼 이벤트 처리 연습"); // 버튼 위에 표시되는 메시지
		button1.setSize(250, 50);
		button1.setLocation(15, 15); // 좌측 상단의 위치 값
		// button1.addActionListener(new ButtonClickHandler()); // 버튼 클릭하면 호출될 메서드 등록 1
		button1.addActionListener( (e) -> {						// 버튼 클릭하면 호출될 메서드 등록 2
			// System.out.println("1. 버튼이 클릭되었습니다.");
			Container container = getContentPane();	// 윈도우 내부의 사용자 작업 영역 가져오기
			container.setBackground(new Color((float)Math.random(), 	// red 
											  (float)Math.random(), 	// green
											  (float)Math.random()));	//blue
		} );		
		add(button1); // 윈도우에 button1을 추가하는 명령
		
		//////////
		
		JButton button2 = new JButton();
		button2.setText("동기 방식 호출"); // 버튼 위에 표시되는 메시지
		button2.setSize(250, 50);
		button2.setLocation(15, 80); // 좌측 상단의 위치 값
		button2.addActionListener( (e) -> {						// 버튼 클릭하면 호출될 메서드 등록
			System.out.println("1. doWork 호출 전");
			TheWorker1 worker = new TheWorker1();
			worker.doWork(); // 10초간 대기
			System.out.println("4. doWork 호출 후");			
		} );		
		add(button2); 
	}
	
	class ButtonClickHandler implements ActionListener { // ActionListener : 클릭 처리기에 대한 약속
		
		@Override
		public void actionPerformed(ActionEvent e) { // 클릭하면 호출되는 메서드			
			System.out.println("버튼이 클릭되었습니다.");			
		}
		
	}

	
	public static void main(String[] args) {
		
		ThreadDemoFrame window = new ThreadDemoFrame();	
		
		window.setVisible(true);

	}

}
