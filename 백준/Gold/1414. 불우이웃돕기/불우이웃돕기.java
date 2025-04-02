import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, total = 0, result = 0, answer = -1;
	static int[] parents;
	static char[][] map;
	static Queue<Node> pq = new PriorityQueue<>();
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		parents = new int[N+1];
		
		for(int i = 0; i < N; i++) 
			map[i] = br.readLine().toCharArray();
		
		for(int i = 1; i <= N; i++) 
			parents[i] = i;
		
		br.close();
	}
	
	static void calc() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if('a' <= map[i][j] && map[i][j] <= 'z') {
					total += map[i][j] - 96;
					pq.add(new Node(i + 1, j + 1, map[i][j] - 96));
				} else if('A' <= map[i][j] && map[i][j] <= 'Z') {
					total += map[i][j] - 38;
					pq.add(new Node(i + 1, j + 1, map[i][j] - 38));
				}
			}
		}
		
		int size = pq.size();
		int cycle = 1;
		
		for(int i = 0; i < size; i++) {
			Node node = pq.poll();
			int rx = find(node.to);
			int ry = find(node.from);
			
			if(rx != ry) {
				cycle++;
				result += node.value;
				union(node.to, node.from);
			}
		}
		
		if(cycle != N) 
			return;
		else 
			answer = total - result;	
    }
	
	static void output() {
		System.out.println(answer);
	}
	
	static int find(int x) { 
		if(parents[x] == x)
			return x; 
		return parents[x] = find(parents[x]);
	} 
	     
	static void union(int x, int y) {
		x = find(x); 
		y = find(y); 
		
	    if(x < y) 
	    	parents[y] = x; 
	    else 
	    	parents[x] = y; 
	}
}

class Node implements Comparable<Node> {
	int to;
	int from;
	int value;
	
	public Node(int to, int from, int value) {
		this.to = to;
		this.from = from;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}