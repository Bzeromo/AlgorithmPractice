import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int x, int y) {
		if(y==0)
			return x;
		else
			return gcd(y, x%y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		int ans = gcd(a, b);
		sb.append(ans).append("\n").append(ans * (a/ans) * (b/ans));
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	} // main
} // class
