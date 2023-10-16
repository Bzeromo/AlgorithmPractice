import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x, value;
	
	Node() {};
	
	Node(int x, int value) {
		this.x = x;
		this.value = value;
	}
}

public class Main {
	static int N;
	static  ArrayList<Node> [] route;
	static boolean [] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		route = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			route[i] = new ArrayList<Node>();
		}
				
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			route[A].add(new Node(B, weight));
			route[B].add(new Node(A, weight));
		}
		
		//트리의 지름은 임의의 정점에서 가장 먼 정점을 찾고
		//찾은 가장 먼 정점에서 제일 멀리있는 정점까지의 거리이다
		//dfs든 bfs든 두 번 돌려서 찾으면 그게 지름이다.
		int max = bfsSearch(1).x;
		
		//가장 먼 정점을 찾았으니 가장 먼 정점을 넣어야겠지?
		//근데 일단 방문 초기화 해야됨. 안하면 바보.
		visited = new boolean[N+1];
		
		//이번에는 정답을 위해 거리를 뽑아
		int ans = bfsSearch(max).value;
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	//트리의 지름을 bfs로 구해보자고
	static Node bfsSearch(int x) {
		if(N == 1) return new Node(0, 0);
		
		//반환할 최대 가중치와 제일 먼 정점 선언
		int max = 0;
		int n = 0;
		
		//bfs니까 q를 만들거야
		Queue<Node> q = new LinkedList<>();
		visited[x] = true;
		// 처음 넣을 녀석은 방문했다고 표시할거야
		
		//처음 넣을 녀석이야, 새로 Node를 만들어 넣어
		q.add(new Node(x, 0));
		
		//q가 비어버릴 때까지 돌려
		while(!q.isEmpty()) {
			//q에서 뽑은 정점을 저장할거야
			Node node = q.poll();
			
			//간선 인접리스트에 들어가있는 만큼 돌릴거야
			for(int i = 0; i < route[node.x].size(); i++) {
				//간선 인접리스트에서 q에서 뽑은 정점과 연결된 놈을 꺼내
				Node node2 = route[node.x].get(i);
				
				//이미 한번 봤던 놈이면 돌아가
				if(visited[node2.x]) continue;
				
				visited[node2.x] = true;
				//그게 아니면 최대 가중치와 먼 정점을 비교하기 위해 새로 선언해
				int nw = node.value + node2.value;
				
				//그리고 q에 아까 꺼낸 연결된 놈과 현재까지의 가중치로 이루어진 간선을 넣어
				q.add(new Node(node2.x, nw));
				
				//지금까지의 가중치가 최대치보다 커지면
				if(nw >= max) {
					//이 녀석이 최대 가중치이고 가장 먼 정점이야
					max = nw;
					n = node2.x;
				}
			}
		}
		
		//모든게 끝나면 가장 먼 정점과 거리를 반환해
		return new Node(n, max);
	}
}