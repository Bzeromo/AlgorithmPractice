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

		StringTokenizer st = new StringTokenizer(br.readLine());
		String answer = "mixed";

		int a = Integer.parseInt(st.nextToken());
		if(a == 1) {
			int cnt = 1;
			for(int i = 2; i <= 8; i++) {
				if(Integer.parseInt(st.nextToken()) == i)
					cnt++;
			}
			if(cnt == 8) 
				answer = "ascending";
		} else if(a == 8) {
			int cnt = 1;
			for(int i = 7; i >= 1; i--) {
				if(Integer.parseInt(st.nextToken()) == i)
					cnt++;
			}
			if(cnt == 8) 
				answer = "descending";
		}
		
		

		bw.write(answer);
		br.close();
		bw.close();
	}

}
