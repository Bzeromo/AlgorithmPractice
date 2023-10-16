import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans = -1;
	static  ArrayList<Integer> [] route;
	static boolean [] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		route = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			route[i] = new ArrayList<Integer>();
		}
				
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			route[A].add(B);
			route[B].add(A);
		}

		bfsSearch();
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	

	static void bfsSearch() {	
		//bfs니까 q를 만들거야
		Queue<Integer> q = new LinkedList<>();
		visited[1] = true;
		// 처음 넣을 녀석은 방문했다고 표시할거야
		
		//처음 넣을 녀석이야, 새로 Node를 만들어 넣어
		q.add(1);
		
		//q가 비어버릴 때까지 돌려
		while(!q.isEmpty()) {
			//q에서 뽑은 정점을 저장할거야
			int node = q.poll();
			ans++;
			//이샊끼 감염됐어
			
			//간선 인접리스트에 들어가있는 만큼 돌릴거야
			for(int i = 0; i < route[node].size(); i++) {
				//간선 인접리스트에서 q에서 뽑은 정점과 연결된 놈을 꺼내
				int node2 = route[node].get(i);
				
				//이미 한번 봤던 놈이면 돌아가
				if(visited[node2]) continue;
				
				//방문처리
				visited[node2] = true;
				
				//그리고 q에 아까 꺼낸 연결된 놈과 현재까지의 가중치로 이루어진 간선을 넣어
				q.add(node2);
			}
		}
	}
}