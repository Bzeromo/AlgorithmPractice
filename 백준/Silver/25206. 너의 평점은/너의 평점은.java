import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		double ans = 0;
		int scoreSum = 0;
		
		for(int i =0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String subject = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(grade.equals("A+")) {
				ans += (score * 4.5);
			} else if (grade.equals("A0")) {
				ans += (score * 4.0);
			} else if (grade.equals("B+")) {
				ans += (score * 3.5);
			} else if (grade.equals("B0")) {
				ans += (score * 3.0);
			} else if (grade.equals("C+")) {
				ans += (score * 2.5);
			} else if (grade.equals("C0")) {
				ans += (score * 2.0);
			} else if (grade.equals("D+")) {
				ans += (score * 1.5);
			} else if (grade.equals("D0")) {
				ans += (score * 1.0);
			} else if (grade.equals("P")) {
				continue;
			}
			
			scoreSum += score;
		}
		
		bw.write(String.format("%.6f", ans/(double)(scoreSum)));
		bw.close();
	}
}

