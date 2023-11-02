import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x, y;
	double value;
	
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Node(int x, int y, double value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		if (this.value < o.value) {
			return -1;
		}
		return 1;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", value=" + value + "]";
	}

	
}

public class Main {
	static int N, M;
	static int [] parent;
	static Node [] god;
	static List<Node> road;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		god = new Node[N+1];
 		road = new ArrayList<>();
 		
 		parent = new int [N+1];
 		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			god[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			union(x, y);
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1 + 1; j <= N; j++) {
				road.add(new Node(i, j, dist(god[i], god[j])));
			}
		}
		
		Collections.sort(road);
		
		for(int i = 0; i < road.size(); i++) {
			Node node = road.get(i);
			if(find(node.x) != find(node.y)) {
				ans += node.value;
				union(node.x, node.y);
			}
		}
		
		bw.write(String.format("%.2f", ans));
		br.close();
		bw.close();
	}
	
	static double dist(Node a, Node b) {
		return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2)); 
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static void union (int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) parent[y] = x;
	}
}
