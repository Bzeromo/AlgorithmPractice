import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N;
	static double answer = 0;
	static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static double[] per;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		per = new double[4];
		
        for(int i = 0; i < 4; i++) {
            per[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }
		
		br.close();
	}
	
	static void calc() {
		boolean[][] visited = new boolean[31][31];
        visited[15][15] = true;
        DFS(15, 15, visited, 0, 1);
    }
	
	static void DFS(int x, int y, boolean[][] visited, int cnt, double result) {
        if(cnt == N) {
            answer += result;
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int dx = x + dr[i];
            int dy = y + dc[i];
 
            if(dx <= 0 || dy <= 0 || dx >= 30 || dy >= 30) 
                continue;
            
            if(!visited[dx][dy]) {
                visited[dx][dy] = true;
                DFS(dx, dy, visited, cnt + 1, result * per[i]);
                visited[dx][dy] = false;
            }
        }
    }
	
	static void output() {
		System.out.println(answer);
	}
	
}