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
		Deque <Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		while(N-- != 0) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if(order.equals("front")) {
				if(!queue.isEmpty())
					sb.append(queue.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			} else if(order.equals("back")) {
				if(!queue.isEmpty())
					sb.append(queue.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
			} else if(order.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if(order.equals("pop")) {
				if(queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.poll()).append("\n");
			} else if(order.equals("empty")) {
				if(!queue.isEmpty())
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
