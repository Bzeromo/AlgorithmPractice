import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N;
	static long max;
	static long temp[];
	static ArrayList<Node> arr[];
	static boolean visited[];
	
	static class Node {
		int node, p ,q;
		
		public Node(int node, int p, int q) {
			this.node = node;
			this.p = p;
			this.q = q;
		}
	}
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N];
		visited = new boolean[N];
		temp = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		long min = 1;
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b, p, q));
			arr[b].add(new Node(a, q, p));
			
			min *= (p*q/gcd(p,q));
		}
		
		temp[0] = min;
		
		br.close();
	}
	
	static void output() {
		for(int i = 0; i < N; i++) {
			System.out.print(temp[i] / max);
			
			if(i < N-1)
				System.out.print(" ");
		}
	}
	
	static void calc() {
		dfs(0);
		max = temp[0];
		
		for(int i = 1; i < N; i++) {
			max = gcd(max, temp[i]);
		}
    }
	
	static long gcd(long a, long b) {
		if(b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	
	static void dfs(int n) {
		visited[n] = true;
		
		for(Node node : arr[n]) {
			int next = node.node;
			
			if(!visited[next]) {
				temp[next] = temp[n] * node.q / node.p;
				dfs(next);
			}
		}
	}
}