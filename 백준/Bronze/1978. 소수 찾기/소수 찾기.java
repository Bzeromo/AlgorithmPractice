import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) cnt--;
			int n = 2;
			for(int i = 0; i < num; i++) {
				if(num % n == 0 && num != 2) {
					cnt--;
					break;
				}
				
				if(++n == num) break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		bw.write(sb.toString());
		bw.close();
	} // main
} // class
