import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque <Integer> deque = new ArrayDeque<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			deque.addLast(i);
			deque.addLast(Integer.parseInt(st.nextToken()));
		}
		
		sb.append(deque.pollFirst()).append(" ");
		int n = deque.pollFirst();
		
		while(!deque.isEmpty()) {
			if(n > 0) {
				for(int i = 1; i < n; i++) {
					deque.addLast(deque.pollFirst());
					deque.addLast(deque.pollFirst());
				}
				sb.append(deque.pollFirst()).append(" ");
				n = deque.pollFirst();
			}
			else {
				for(int i = 1; i < n*-1; i++) {
					deque.addFirst(deque.pollLast());
					deque.addFirst(deque.pollLast());
				}
				
				n = deque.pollLast();
				sb.append(deque.pollLast()).append(" ");		
			}
		}
		
		bw.write(sb.delete(sb.length()-1, sb.length()).toString());
		br.close();
		bw.close();
	}

}
