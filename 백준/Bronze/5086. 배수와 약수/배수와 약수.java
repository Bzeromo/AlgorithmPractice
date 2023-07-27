import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(n1 == 0 && n2 == 0) {
				break;
			}
			bw.write(solve(n1, n2) + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	public static String solve(int n1, int n2) {
		String answer;
		
		if(n2 % n1 == 0) answer = "factor";
		else if(n1 % n2 == 0) answer = "multiple";
		else answer = "neither";
		
		return answer;
	}
}
