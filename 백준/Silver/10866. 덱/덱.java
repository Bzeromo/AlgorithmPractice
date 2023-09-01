import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Deque <Integer> deque = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		while(N-- != 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push_front")) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if(order.equals("push_back")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if(order.equals("front")) {
				if(!deque.isEmpty())
					sb.append(deque.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			} else if(order.equals("back")) {
				if(!deque.isEmpty())
					sb.append(deque.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
			} else if(order.equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if(order.equals("pop_back")) {
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollLast()).append("\n");
			} else if(order.equals("pop_front")) {
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollFirst()).append("\n");
			}else if(order.equals("empty")) {
				if(!deque.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
			} 
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	
}
