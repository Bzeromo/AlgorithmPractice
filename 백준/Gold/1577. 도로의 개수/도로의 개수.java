import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, M;
	static long dp[][];
	static boolean[][][] road;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		
		dp = new long[M+1][N+1];
		road = new boolean[M+1][N+1][2];
		
		for(int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(a < c || b < d) {
                if(a < c)
                	road[b][a][0] = true;
                else 
                	road[b][a][1] = true;
            }else {
                if(c < a) 
                	road[d][c][0] = true;
                else 
                	road[d][c][1] = true;
            }
		}
		
		br.close();
	}
	
	static void output() {
		System.out.println(dp[M][N]);
	}
	
	static void calc() {
		dp[0][0] = 1;

        for(int i = 1; i <= N; i++) {
        	if(road[0][i-1][0]) 
        		break;
        	dp[0][i] = 1;
        }

        for(int i = 1; i <= M; i++) {
        	if(road[i-1][0][1]) 
        		break;
        	dp[i][0] = 1;
        }

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
            	if (!road[i][j-1][0]) dp[i][j] += dp[i][j-1];
            	if (!road[i-1][j][1]) dp[i][j] += dp[i-1][j];
            }
        }
	}
}