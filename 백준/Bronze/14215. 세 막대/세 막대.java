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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int max = Math.max(a, Math.max(c, b));
		if(a == max) {
			if(b + c > a)
				answer = a + b + c;
			else
				answer = 2*(b+c)-1;
		} else if(b == max) {
			if(a + c > b)
				answer = a + b + c;
			else
				answer = 2*(a+c)-1;
		} else {
			if(b + a > c)
				answer = a + b + c;
			else
				answer = 2*(b+a)-1;
		}
		
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
