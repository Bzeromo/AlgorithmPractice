import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x, y;
	
	Node (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int [][] ice;
	static int N, M, year = 1, ans = -1, meltCnt = 0;
	static Queue<Node> q;
	//동서남북
	static int dr [] = {0, 0, 1, -1};
	static int dc [] = {1, -1, 0, 0};
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ice = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		solution();
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(ice[i][j]);
//			}
//			System.out.println();
//		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	static void melt(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if(nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny]) continue;
			
			if(ice[nx][ny] == 0)
				meltCnt++;
		}
		
		if(ice[x][y] - meltCnt <= 0) {
			ice[x][y] = 0;
			visited[x][y] = true;
		} else {
			ice[x][y] -= meltCnt;
		}
		
		meltCnt = 0;
	}
	
	static void search () {
		int piece = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(ice[i][j] != 0 && !visited[i][j]) {
					q = new LinkedList<Node>();

					q.add(new Node(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Node node = q.poll();
						int x = node.x;
						int y = node.y;
						
						for(int k = 0; k < 4; k++) {
							int nx = x + dr[k];
							int ny = y + dc[k];

							if(nx >= N || nx < 0 || ny >= M || ny < 0 || visited[nx][ny]) continue;
							
							if(ice[nx][ny] != 0) {
								visited[nx][ny] = true;
								q.add(new Node(nx, ny));
							}
						}
					}

					if(++piece >= 2) {
						ans = year;
						return;
					}
				}
			}
		}
		
		if(piece == 0) ans = 0;
	}
	
	static void solution () {
		if(ans != -1) return;
		
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(ice[i][j] != 0)
					melt(i, j);
			}
		}
		
		visited = new boolean[N][M];
		search();
		year++;
		solution();
	}
	
}