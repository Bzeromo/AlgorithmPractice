import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int [] visited = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		List <List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i), new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
		}
		
		int cnt = 1;
		
		q.add(R);
		visited[R] = cnt++;;
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for(int i = 0; i < list.get(t).size(); i++) {
				int next = list.get(t).get(i);
				
				if(visited[next] != 0) 
					continue;
				
				q.add(next);
				visited[next] = cnt++;
			}
		}
		
		for(int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}