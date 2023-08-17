import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(fib(N)));
		bw.close();
	}
	
	public static long[] memo = new long [91];
	
	static {
		memo[0] = 0;
		memo[1] = 1;
	}

	public static long fib (int num) {
		if(num >= 2 && memo[num] == 0) {
			memo[num] = fib(num-1) + fib(num-2);
		}
		return memo[num];
	}
}
