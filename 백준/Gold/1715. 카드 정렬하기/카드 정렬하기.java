import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long ans = 0;
		long tmp = 0;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) 
			pq.add(Long.parseLong(br.readLine()));
		
		if(N != 1) {
			while(!pq.isEmpty()) {
				tmp = pq.poll();
				
				if(!pq.isEmpty()) {
					tmp += pq.poll();
					pq.add(tmp);
					ans += tmp;
				}
			}
		}
		
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
}