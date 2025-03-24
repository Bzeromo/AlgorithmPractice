import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int dp [] = new int [1000001];
	
	static {
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
	}
	
	public static void solve() throws IOException{
		int N = input();
		System.out.print(fibo(N));
	}
	
	static int input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		return N;
	}
	
	static int fibo(int N) {
		if(dp[N] == -1) 
			dp[N] = (fibo(N-1) + fibo(N-2)) % 15746;
		
		return dp[N];
	}
}