import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static int N;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int arr [][];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		
		arr = new int [N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		DFS(v);
		visited = new boolean[N+1];
		sb.append("\n");
		BFS(v);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void DFS(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && arr[v][i] == 1) {
				DFS(i);
			}
		}
	}
	
	static void BFS(int v) {
		visited[v] = true;
		q.add(v);
		
		while(!q.isEmpty()) {
			int t = q.poll();
			sb.append(t).append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && arr[t][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
}

