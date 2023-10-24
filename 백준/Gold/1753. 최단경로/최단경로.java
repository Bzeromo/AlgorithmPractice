import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int v, w;
	
	Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
}

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V, E, K, min, idx;
	static List<Node>[] adjList;
	static int distance[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V+1];
		distance = new int [V+1];
		
		Arrays.fill(distance, INF);
		
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;

			adjList[start].add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		dijkstra(K-1);
		
		for(int i = 0; i < V; i++) {
			if(distance[i] == INF)
				sb.append("INF\n");
			else
				sb.append(distance[i]).append("\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void dijkstra(int start) {
		visited = new boolean[V];
		
		distance[start] = 0;
		
		for(int i = 0; i < V-1; i++) {
			min = INF;
			idx = -1;
			
			for(int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					idx = j;
				}
			}
			if(idx == -1) break;
			
			visited[idx] = true;
			
			for(int j = 0; j < adjList[idx].size(); j++) {
				Node temp = adjList[idx].get(j);
				
				if(!visited[temp.v] && distance[temp.v] > distance[idx]+temp.w) {
					distance[temp.v] = distance[idx] + temp.w;
				}
			}
		}
	}
}

