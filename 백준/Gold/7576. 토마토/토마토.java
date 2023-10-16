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
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, max = 0, day;
	static Queue<Node> q;
	static boolean end = true;
	static int [][] tomato;
	static boolean [][] visited;
	//상하좌우
	static int [] dr = {-1, 1, 0, 0};
	static int [] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		day = 1;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new LinkedList<Node>();
		visited = new boolean[M+1][N+1];
		tomato = new int [M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loop: for(int i = 0; i < M; i++) {
			for(int j =0; j < N; j++) {
				if(tomato[i][j] != 1) {
					end = false;
					break loop;
				}
			}
		}
		
	
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(tomato[i][j] == 1) {
					q.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		loop: for(int i = 0; i < M; i++) {
			for(int j =0; j < N; j++) {
				if(tomato[i][j] == 0) {
					max = -1;
					break loop;
				}
			}
		}
		
		if(end) max = 0;
		
		bw.write(String.valueOf(max));
		br.close();
		bw.close();
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			int nx = node.x;
			int ny = node.y;
			
			day = tomato[nx][ny];
			
			for(int i = 0; i < 4; i++) {			
				int rx = nx + dr[i];
				int ry = ny + dc[i];
				
				if(rx >= M || rx < 0 || ry >= N || ry < 0 || 
						visited[rx][ry]) continue;
				
				visited[rx][ry] = true;
				
				if(tomato[rx][ry] == -1) continue;
				
				if(tomato[rx][ry] == 0) {
					max = Math.max(max, day);
					tomato[rx][ry] = day+1;
					q.add(new Node(rx, ry));
				}			
			}
		}
	}
	
	
}