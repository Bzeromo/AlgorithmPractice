import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a, b;
	static int [] set;
	static int [] rank;
	static List<Integer>[] edges; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			set = new int [N+1];
			rank = new int [N+1];
			edges = new ArrayList[M+2];
			
			for(int i = 0; i <= M+1; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i <= N; i++) {
				set[i] = i;
				rank[i] = 0;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				edges[a].add(b);
				edges[b].add(a);
			}
			
			sb.append(N-1).append("\n");
		}
		
		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static int findSet(int a) {
		if(a != set[a])
			set[a] = findSet(set[a]);
		return set[a];
	}
	
	static void union(int a, int b) {
		int findX = findSet(a);
		int findY = findSet(b);
		
		if(rank[findX] > rank[findY])
			set[findY] = findX;
		else {
			set[findX] = findY;
			if(rank[findX] == rank[findY])
				rank[findY]++;
		}
	}
}