import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		while(N-- != 0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0 && !heap.isEmpty()) 
				sb.append(heap.poll()).append("\n");
			else if(n==0 && heap.isEmpty())
				sb.append(String.valueOf(0)).append("\n");
			else
				heap.add(n);
		}
		
		bw.write(sb.delete(sb.length()-1, sb.length()-1).toString());
		bw.close();
	}
}
