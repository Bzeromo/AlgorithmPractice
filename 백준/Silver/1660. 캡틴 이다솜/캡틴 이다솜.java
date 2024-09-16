import java.io.*;
import java.util.Arrays;
 
public class Main {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp1 = new int[122];
		int[] dp2 = new int[122];
		dp1[1] = 1;
		dp2[1] = 1;
		for (int i = 2; i < 122; i++) {
			dp1[i] = dp1[i-1] + i;
			dp2[i] = dp1[i] + dp2[i-1];
		}
		int[] res = new int[N+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		res[1] = 1;
		for (int i = 2; i <= N; i++) {
			
			for (int j = 1; j < 122; j++) {
				if(dp2[j] > i) break;
				res[i] = Math.min(res[i], res[i - dp2[j]]+1);
			}
		}
		System.out.println(res[N]);
	}
 
}