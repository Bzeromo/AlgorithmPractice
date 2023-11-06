import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
			tree.add(new ArrayList<>());

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}

		boolean[] visited = new boolean[n]; 
		int[] parentNode = new int[n]; 

		// BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int node : tree.get(v))
				if (!visited[node]) {
					visited[node] = true;
					queue.add(node);
					parentNode[node] = v; 
				}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < n; i++)
			sb.append(parentNode[i] + 1).append("\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}