import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		//인접리스트
		List<ArrayList<Integer>> adjArr = new ArrayList<>(); //1번 정점부터 시작해서 V번까지
		List<Integer>  degree = new ArrayList<>(); //진입차수를 저장할 배열
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i <= V; i++) {
			adjArr.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i <= V; i++) {
			degree.add(0);
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			//유향그래프
			adjArr.get(A).add(B); //가중치가 따로 주어지지 않았기 때문에
			//진입차수를 증가
			degree.set(B, degree.get(B)+1);
		}
		
		for(int i = 1; i < V+1; i++) {
			if(degree.get(i) == 0)
				q.add(i);
		}
		
		while(!q.isEmpty()) {
			int w = q.poll();
			
			sb.append(w).append(" ");
			
			List<Integer> list = adjArr.get(w);

	        for (int i = 0; i < list.size(); i++) {
	            int idx = list.get(i);
	            degree.set(idx, (degree.get(idx) -1));
	            if (degree.get(idx) == 0) {
	                q.offer(idx);
	            }
	        }
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	
}