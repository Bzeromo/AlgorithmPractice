import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long gcd(long x, long y) {
		if(y==0)
			return x;
		else
			return gcd(y, x%y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
			
		long ans = gcd(a, b);
			
		StringBuilder sb = new StringBuilder();
		bw.write(sb.append(ans * (a/ans) * (b/ans)).append("\n").toString());
		
		bw.close();
	} // main
} // class
