import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int x, y, dist;
	
	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.dist - o.dist;
	}
}

public class Main {
	static int N, M, islandCnt;
	static int X, Y, Z;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static Queue<int[]> q;
	//상하좌우
	static int dr [] = {-1, 1, 0, 0};
	static int dc [] = {0, 0, -1, 1};
	static int par[];
	static int [][] map;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		islandCnt = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					coloring(i, j);
					islandCnt++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					bridge(i, j, map[i][j]);
				}
			}
		}
		
		par = new int[--islandCnt];
		for(int i = 1; i < islandCnt; i++) {
			par[i] = i;
		}
		int answer = kruskal();
		
		answer = (answer == 0 ? -1 : answer);
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	
	static void coloring (int x, int y) {
		if(!isPossible(x, y) || visited[x][y] || map[x][y] == 0)
			return;
		
		visited[x][y] = true;
		map[x][y] = islandCnt;
		
		for(int i = 0; i < 4; i++) {
			coloring(x + dr[i], y + dc[i]);
		}
		
		visited[x][y] = false;
	}
	
	static void bridge (int x, int y, int idx) {
		q = new LinkedList<>();
		visited = new boolean[N][M];
		
		for(int i = 0; i < 4; i++) {
			q.add(new int[] {x, y, 0});
			visited[x][y] = true;
			
			while(!q.isEmpty()) {
				int [] p = q.poll();
				int px = p[0];
				int py = p[1];
				int dist = p[2];
				
				int nx = px + dr[i];
				int ny = py + dc[i];
				
				if(!isPossible(nx, ny) || visited[nx][ny]) continue;
				
				if(map[nx][ny] != idx) {
					if(map[nx][ny] != 0) {
						int start = idx - 1;
						int end = map[nx][ny] - 1;
						int length = dist;
						
						if(length > 1) {
							pq.add(new Node(start, end, length));
							break;
						}
					} else {
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny, dist+1});
					}
				}
			}
			q.clear();
		}
	}
	
	static int kruskal () {
		 int sum = 0;
		 int size = pq.size();
		 for(int i = 0; i < size; i++) {
			 Node node = pq.poll();
			 int x = node.x;
			 int y = node.y;
			 
			 if(findSet(x) != findSet(y)) {
				 sum += node.dist;
				 union(x, y);
			 }
		 }
		 
		 int rx = par[1];
		 for(int i = 2; i < islandCnt; i++) {
			 if(rx != findSet(par[i])) {
				 return 0;
			 }
		 }
		 
		 return sum;
	}
	
	static boolean isPossible (int x, int y) {
		return x < N && x >= 0 && y < M && y >= 0;
	}
	
	static int findSet(int x) {
		if(x != par[x])
			par[x] = findSet(par[x]);
		return par[x];
	}
	
	static void union(int x, int y) {
		int findX = findSet(x);
		int findY = findSet(y);
		
		if(findX < findY)
			par[findY] = findX;
		else
			par[findX] = findY;
	}
}
