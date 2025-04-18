import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, M, start, end;
	static ArrayList<ArrayList<Node>> list;
	static int[] add;
	static long[] total;
	static String answer;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		add = new int[N];
		total = new long[N];
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, -cost));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			add[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	static void calc() {
		if(!bfs(start, end)) {
			answer = "gg";
		} else {
			if(bf(start, end)) {
				answer = "Gee";
			} else {
				answer = String.valueOf(total[end]);
			}
		}
	}

	static boolean bfs(int startCity, int endCity) {
		if(startCity == endCity)
			return true;

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		q.add(startCity);
		visited[startCity] = true;

		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(Node node : list.get(current)) {
				if (!visited[node.end]) {
					if (node.end == endCity)
						return true;
					visited[node.end] = true;
					q.add(node.end);
				}
			}
		}
		return false;
	}
	
	static boolean bf(int start, int end) {
		Arrays.fill(total, Long.MIN_VALUE);
		total[start] = add[start];

		boolean update = false;

		for(int i = 0; i < N - 1; i++) {
			update = false;

			for(int j = 0; j < N; j++) {
				if(total[j] == Long.MIN_VALUE)
					continue;

				for(Node node : list.get(j)) {
					if(total[node.end] < total[j] + node.weight + add[node.end]) {
						total[node.end] = total[j] + node.weight + add[node.end];
						update = true;
					}
				}
			}

			if(!update)
				break;
		}

		Set<Integer> cycleNodes = new HashSet<>();
		for(int i = 0; i < N; i++) {
			if(total[i] == Long.MIN_VALUE)
				continue;

			for(Node node : list.get(i)) {
				if(total[node.end] < total[i] + node.weight + add[node.end]) {
					cycleNodes.add(i);
					cycleNodes.add(node.end);
				}
			}
		}

		for(int node : cycleNodes) {
			if(bfs(node, end)) {
				return true;
			}
		}

		return false;
	}
	
	static void output() {
		System.out.println(answer);
	}
}

class Node {
	int end, weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}
