import java.io.*;
import java.util.*;

public class Main {
	static int N, root[], ans, cnt;
	static List<Edge> edgeList = new ArrayList<>();
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		root = new int[N+1];
		for (int i=1;i<=N;i++) {
			edgeList.add(new Edge(0, i, Integer.parseInt(br.readLine())));
		}
		StringTokenizer st = null;
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				int value = Integer.parseInt(st.nextToken());
				if (i!=j) edgeList.add(new Edge(i, j, value));
			}
		}
		makeSet(); 
		Collections.sort(edgeList);
        
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				ans += edge.weight;
				if (++cnt == N) {
					System.out.println(ans);
					System.exit(0);
				}
			}
		}
	}
	
	static void makeSet() {
		for (int i=0;i<=N;i++) {
			root[i] = -1;
		}
	}
	
	static int findSet(int x) {
		if (root[x] < 0) return x;
		return root[x] = findSet(root[x]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) 
            return false;
		root[bRoot] = aRoot;
		return true;
	}
}