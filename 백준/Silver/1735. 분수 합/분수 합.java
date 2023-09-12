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
		
		int A1 = Integer.parseInt(st.nextToken());
		int B1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int A2 = Integer.parseInt(st.nextToken());
		int B2 = Integer.parseInt(st.nextToken());
		
		int A, B, C;
		C = gcd(B1, B2);
		B = C * (B1/C) * (B2/C);
		A = (A1*(B/B1)) + (A2*(B/B2));
		
		for(int i = 2; i <= Math.min(A, B); i++) {
			if(A % i == 0 && B % i == 0) {
				A /= i;
				B /= i;
				i--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(A).append(" ").append(B);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static int gcd(int x, int y) {
		if(y==0)
			return x;
		else
			return gcd(y, x%y);
	}
}