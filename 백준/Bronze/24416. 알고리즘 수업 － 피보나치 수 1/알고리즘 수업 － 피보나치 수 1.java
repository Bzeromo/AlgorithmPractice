import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int fibo[] = new int [51];
	static int dumbFiboCnt = 0;
	static int smartFiboCnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibo(n);
		
		StringBuilder sb = new StringBuilder();
		
		bw.write(sb.append(dumbFiboCnt).append(" ").append(smartFiboCnt).toString());
		br.close();
		bw.close();
	}
	
	static int fib(int n) {
		fibo[1] =1;
		fibo[2] =1;
		for(int i = 3; i <= n; i++) {
			smartFiboCnt++;
			fibo[i] = fibo[i - 1] + fibo[i - 2];  
		}
		return fibo[n];
	}
	
	static int fibo(int n) {
		if (n == 1 || n == 2) {
			dumbFiboCnt++;
			return 1;	
		} 
	    
	    return (fibo(n - 1) + fibo(n - 2));
	}
}