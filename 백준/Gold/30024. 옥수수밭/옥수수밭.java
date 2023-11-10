import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int x, y, val;
	
	Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return o.val - this.val;
	}
}

public class Main {
	static int N, M, K, max = 0;
	static int oksusu [][];
	static boolean visited [][];
	static PriorityQueue<Node> pq;
	static Queue<Node> q;
	static StringBuilder sb = new StringBuilder();
	//상하좌우
	static int dr [] = {-1, 1, 0, 0};
	static int dc [] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oksusu = new int [N][M];
		q = new LinkedList<Node>();
		pq = new PriorityQueue<>();
		visited = new boolean [N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				oksusu[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 || i == N-1 || j == 0 || j == M-1) {
					pq.add(new Node(i, j, oksusu[i][j]));
					visited[i][j] = true;
				}	
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		// 델타로 모든 경우의 수에 BFS로 들어가 우선순위 큐안에 상하좌우 친구들 넣어가며 최대치 확인
		
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			q.add(n);
			
			//q sb에 복사
			if(++cnt == K) {	
				while(!q.isEmpty()) {
					Node node = q.poll();
					sb.append(node.x+1).append(" ").append(node.y+1).append("\n");
				}
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int rx = n.x + dr[i];
				int ry = n.y + dc[i];
				
				if(rx >= N || rx < 0 || ry >= M || ry < 0 || visited[rx][ry]) continue;
				
				pq.add(new Node(rx, ry, oksusu[rx][ry]));
				visited[rx][ry] = true;
			}
		}
		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}