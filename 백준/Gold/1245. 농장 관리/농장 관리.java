import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x, y, val;
	
	Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

public class Main {
	static int N, M, ans = 0;
	static int mountain[][];
	static boolean visited[][], counted[][];
	static Queue<Node> q, q2;
	//상하좌우 북동 북서 남동 남서
	static int dr [] = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int dc [] = {0, 0, -1, 1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mountain = new int [N][M];
		counted = new boolean [N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				
				mountain[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!counted[i][j])
					BFS(new Node(i, j, mountain[i][j]));
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	static void BFS(Node node) {
		q = new LinkedList<>();
		q2 = new LinkedList<>();
		visited = new boolean[N][M];
		q.add(node);
		
		visited[node.x][node.y] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			q2.add(n);
			
			for(int i = 0; i < 8; i++) {
				int rx = n.x + dr[i];
				int ry = n.y + dc[i];
				
				if(rx >= N || rx < 0 || ry >= M || ry < 0) continue;
				
				if(mountain[rx][ry] > n.val) return;
				
				if(visited[rx][ry]) continue;
				
				if(mountain[rx][ry] == n.val) {
					q.add(new Node(rx, ry, mountain[rx][ry]));
					visited[rx][ry] = true;
				}
			}
		}
		while(!q2.isEmpty()) {
			Node n = q2.poll();
			
			counted[n.x][n.y] = true;
		}
		ans++;
	}
}
