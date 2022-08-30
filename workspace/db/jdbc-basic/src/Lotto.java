import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// 데이터베이스에 테이블 만들기
// (winning-numbers.txt 내용을 참고해서 ...)
//		CREATE TABLE tbl_lotto
//		(
//			rnd int not null primary key, -- auto_increment 아님
//		    lottery_date datetime not null,
//		    no1 decimal(2, 0) not null, -- no1 numeric(2, 0) not null,
//		    no2 decimal(2, 0) not null,
//		    no3 decimal(2, 0) not null,
//		    no4 decimal(2, 0) not null,
//		    no5 decimal(2, 0) not null,
//		    no6 decimal(2, 0) not null,
//		    bonus decimal(2, 0) not null
//		);

public class Lotto {

	public static void main(String[] args) {
		
		// winning-numbers.txt 파일 읽기
		// 파일의 데이터를 데이터베이스에 저장
		
		//1. 파일 읽기
		FileInputStream fis = null;		// 파일 데이터 읽기 기능 제공
		InputStreamReader isr = null;	// byte[] -> char[] (String)으로 변환 기능 제공
		BufferedReader br = null; 		// 한 행 단위로 텍스트 파일 읽기 기능 제공
		ArrayList<LottoDto> dataSet = new ArrayList<>(); // 읽은 데이터 저장 변수
		try {
			fis = new FileInputStream("winning-numbers.csv");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd"); // 날짜 <-> 특정형식문자열
			while (true) {
				String line = br.readLine();
				if (line == null) break; // EOF ( End of File )
				
				//System.out.println(line);
				String[] row = line.split(","); // "a,b,c" -> ["a", "b", "c"]
				
				LottoDto l = new LottoDto();
				l.setRnd(Integer.parseInt(row[0]));
				l.setLotteryDate(sdf.parse(row[1])); // "2022.08.27" -> Date
				l.setNo1(Integer.parseInt(row[2]));
				l.setNo2(Integer.parseInt(row[3]));
				l.setNo3(Integer.parseInt(row[4]));
				l.setNo4(Integer.parseInt(row[5]));
				l.setNo5(Integer.parseInt(row[6]));
				l.setNo6(Integer.parseInt(row[7]));
				l.setBonus(Integer.parseInt(row[8]));
				System.out.println(l);
				dataSet.add(l);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { br.close(); } catch (Exception ex) {}
			try { isr.close(); } catch (Exception ex) {}
			try { fis.close(); } catch (Exception ex) {}
		}
		
		// 데이터 읽기 끝
		
		// 2. 데이터베이스에 저장

	}

}










