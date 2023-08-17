import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fib(N);
			bw.write(String.valueOf(memo[N][0]) + " " + String.valueOf(memo[N][1]) + "\n");
		}
		bw.close();
	}
	
	public static Integer[][] memo = new Integer [41][2];
	
	static {
		memo[0][0] = 1;
		memo[1][0] = 0;
		memo[0][1] = 0;
		memo[1][1] = 1;
	}
	
	public static Integer[] fib (int N) {
		if(memo[N][0] == null || memo[N][1] == null) {
			memo[N][0] = fib(N-1)[0] + fib(N-2)[0];
			memo[N][1] = fib(N-1)[1] + fib(N-2)[1];
		}
		
		return memo[N];
	}
}
