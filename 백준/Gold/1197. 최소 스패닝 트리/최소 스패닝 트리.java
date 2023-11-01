import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x, y, value;
	
	Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}

public class Main {
	static int V, E, min = 0;
	static List<Node> [] road;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		road = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i = 1; i <= V; i++) {
			road[i] = new ArrayList<Node>();
		}
		
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			road[x].add(new Node(x, y, z));
			road[y].add(new Node(y, x, z));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		visited[1] = true;
		
		for(int i = 0; i < road[1].size(); i++) {
			pq.add(road[1].get(i));
		}
		
		int pick = 1;
		
		while(pick != V) {
			Node n = pq.poll();
			if(visited[n.y]) continue;
			
			min += n.value;
			pq.addAll(road[n.y]);
			visited[n.y] = true;
			pick++;
		}
		
		bw.write(String.valueOf(min));
		br.close();
		bw.close();
	}
	
	
}
