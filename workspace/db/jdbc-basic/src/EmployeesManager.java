import java.util.List;
import java.util.Scanner;

public class EmployeesManager {
	
	private Scanner scanner = new Scanner(System.in);
	
	private EmployeeDao dao = new EmployeeDao();
	
	public void doManage() {
	
		outer : while (true) {
			
			String task = selectTask();
			
			System.out.println();
			
			switch (task) {
			case "1" : 
				List<EmployeeDto> employees1 = dao.selectAllEmployees();
				System.out.println("***** 전체 직원 목록 *****");
				showList(employees1);
				break;
			case "2" : 
				System.out.print("검색할 사원 번호 : ");
				int empNo = scanner.nextInt(); // 버퍼에 enter가 남아서 다음 nextLine에 영향을 미침
				scanner.nextLine(); // 버퍼에 남아있는 enter 제거
				List<EmployeeDto> employees2 = dao.selectEmployeesByEmpNo(empNo);
				System.out.println("***** 직원 목록 *****");
				showList(employees2);
				break;
			case "3" : 
				System.out.print("검색할 사원 이름 : ");
				String name = scanner.nextLine();
				List<EmployeeDto> employees3 = dao.selectEmployeesByName(name);
				System.out.println("***** 직원 목록 *****");
				showList(employees3);
				break;
			case "4" : break;
			case "5" : break;
			case "0" : 
				System.out.println("프로그램을 종료합니다.");
				break outer;
			}
			
			System.out.println();
		}
		
	}
	
	

	private void showList(List<?> list) {	
		for (Object obj : list) {
			System.out.println(obj);
		}
	}



	private String selectTask() {
		System.out.println("******************************");
		System.out.println("* 1. 모든 직원 조회             *");
		System.out.println("* 2. 직원 조회 (번호)           *");
		System.out.println("* 3. 직원 조회 (이름)           *");
		System.out.println("* 0. 종료                     *");
		System.out.println("******************************");
		System.out.print("작업을 선택하세요 : ");
		String task = scanner.nextLine();
		return task;
	}



	public static void main(String[] args) {
		
		EmployeesManager manager = new EmployeesManager();
		manager.doManage();

	}

}
