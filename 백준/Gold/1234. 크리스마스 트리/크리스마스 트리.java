import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long[][][][] dp = new long[N+1][R+1][G+1][B+1];
		
		
		for (int i = 0; i <= N; i++) {
			for (int r = 0; r <= R; r++) {
				for (int g = 0; g <= G; g++) {
					for (int b = 0; b <= B; b++) {
						if(i == 0) { // 초기값 세팅
							dp[i][r][g][b] = 1;
							continue;							
						}
                        // i단을 하나의 색으로만 꾸밈
						if(r-i>=0) dp[i][r][g][b] += dp[i-1][r-i][g][b] * 1;
						if(g-i>=0) dp[i][r][g][b] += dp[i-1][r][g-i][b] * 1;
						if(b-i>=0) dp[i][r][g][b] += dp[i-1][r][g][b-i] * 1;
                        // i단을 2개의 색으로 꾸밈
						if(i%2 == 0) {
							int divNum = i/2;
							if(g-divNum>=0 && b-divNum>=0) dp[i][r][g][b] += dp[i-1][r][g-divNum][b-divNum]*comb(i,divNum);
							if(r-divNum>=0 && b-divNum>=0) dp[i][r][g][b] += dp[i-1][r-divNum][g][b-divNum]*comb(i,divNum);
							if(r-divNum>=0 && g-divNum>=0) dp[i][r][g][b] += dp[i-1][r-divNum][g-divNum][b]*comb(i,divNum);
						}
                        // i단을 3개의 색으로 꾸밈
						if(i%3 == 0) {
							int divNum = i/3;
							if(r-divNum>=0 && g-divNum>=0 && b-divNum>=0) dp[i][r][g][b] += dp[i-1][r-divNum][g-divNum][b-divNum]*comb(i,divNum) * comb(i-divNum,divNum);
						}
					}
				}
			}
		}
		System.out.println(dp[N][R][G][B]);
	}
	public static int comb(int n, int r) {
		return factorial(n)/(factorial(r)*factorial(n-r));
	}
	public static int factorial(int x) {
		if(x == 1) return 1;
		return x*factorial(x-1);
	}
}