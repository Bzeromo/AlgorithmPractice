import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		Queue <Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int n = 0;
		
		while(!queue.isEmpty()) {
			if(++n == K) {
				sb.append(queue.poll()).append(", ");
				n = 0;
			} else {
				queue.add(queue.poll());
			}
		}
		
		bw.write(sb.delete(sb.length()-2, sb.length()).append(">").toString());
		br.close();
		bw.close();
	}

}
