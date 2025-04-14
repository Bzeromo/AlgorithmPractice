import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int T, N;
	static int[][] P;
	static boolean[] visited;
	static double min;
	static StringBuilder sb = new StringBuilder();
	
	public static void solve() throws IOException {
		input();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			P = new int[N][2];
			
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				P[j][0] = x;
				P[j][1] = y;
			}
			calc();
		}
		
		br.close();
	}
	
	static void calc() {
		visited = new boolean[N];
		min = Double.MAX_VALUE;
		comb(0, N/2);
		
		sb.append(min + "\n");
    }
	
	static void comb(int index, int cnt) {
 		if(index == P.length)
 			return;
 		
 		if(cnt == 0) 
 			min = Math.min(min, vector());
 		
 		for(int i = index; i < P.length; i++) {
 			visited[i] = true;
 			comb(i+1, cnt-1);
 			visited[i] = false;
 		}
 	}
	
	static double vector() {
 		int x = 0;
 		int y = 0;
 		
 		for(int i = 0; i < P.length; i++) {
 			if(visited[i]) {
 				x += P[i][0];
 				y += P[i][1];
 			} else {
 				x -= P[i][0];
 				y -= P[i][1];
 			}
 		}
 		
 		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
 	}
	
	static void output() {
		System.out.println(sb);
	}
	
}