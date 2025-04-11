import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int K, W, H;
	static int[][] map;
	static int answer = 0;
	static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		br.close();
	}
	
	static void calc() {
		boolean[][][] visited = new boolean[H][W][K+1];
        answer = bfs(0, 0, visited, K);
    }
	
	static int bfs(int x, int y, boolean[][][] visited, int k) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(x, y, 0, 0));
		
		visited[x][y][0] = true;
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			
			int curX = p.x;
			int curY = p.y;
			
			if(curX == H-1 && curY == W-1) {
				return p.m;
			}
			
			for(int t = 0; t < 4; t++) {
				int nx = curX + dr[t];
				int ny = curY + dc[t];
				
				if(isImpossible(nx, ny) || visited[nx][ny][p.h]) 
					continue;
				
				if(map[nx][ny] == 0) {
					visited[nx][ny][p.h] = true;
					q.add(new Node(nx, ny, p.h, p.m + 1));
				}
			}
			
			if(p.h < k) {
				for(int t = 0; t < 8; t++) {
					int nx = curX + hr[t];
					int ny = curY + hc[t];
					
					if(isImpossible(nx, ny) || visited[nx][ny][p.h + 1]) 
						continue;
					
					if(map[nx][ny] == 0) {
						visited[nx][ny][p.h + 1] = true;
						q.add(new Node(nx, ny, p.h + 1, p.m + 1));
					}
				}
			}
			
			
		}
		
		return -1;
    }
	
	static boolean isImpossible(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= H || ny >= W;
	}
	
	static void output() {
		System.out.println(answer);
	}
	
}

class Node{
	int x, y, h, m;
	
	Node(int x, int y, int h, int m){
		this.x = x;
		this.y = y;
		this.h = h;
		this.m = m;
	}
}