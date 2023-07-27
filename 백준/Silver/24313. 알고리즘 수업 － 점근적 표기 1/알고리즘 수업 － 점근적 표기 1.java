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
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(bf.readLine());
		int n0 = Integer.parseInt(bf.readLine());
		
		bw.write(String.valueOf(solve(a1, a2, c, n0)));
		bw.flush();
		bw.close();
	}
	
	public static int solve(int a1, int a2, int c, int n0) {
		
		for(int i = 100; i >= n0; i--) {
			int ans = a1*i+a2;
			int ans2 = i * c;
			
			if(ans > ans2) return 0;
		}
	
		return 1;
	}
}
