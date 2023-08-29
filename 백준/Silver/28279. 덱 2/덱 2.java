import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque <Integer> deque = new LinkedList<Integer>();
		
		while(N-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			switch(order) {
			case 1: deque.addFirst(Integer.parseInt(st.nextToken()));
			break;
			case 2: deque.addLast(Integer.parseInt(st.nextToken()));
			break;
			case 3: if(!deque.isEmpty()) sb.append(deque.pollFirst()).append("\n");
			else sb.append(-1).append("\n");
			break;
			case 4: if(!deque.isEmpty()) sb.append(deque.pollLast()).append("\n");
			else sb.append(-1).append("\n");
			break;
			case 5: sb.append(deque.size()).append("\n");
			break;
			case 6: if(!deque.isEmpty()) sb.append(0).append("\n");
			else sb.append(1).append("\n");
			break;
			case 7:  if(!deque.isEmpty()) sb.append(deque.peekFirst()).append("\n");
			else sb.append(-1).append("\n");
			break;
			case 8:  if(!deque.isEmpty()) sb.append(deque.peekLast()).append("\n");
			else sb.append(-1).append("\n");
			break;
			}
			
			
			
		}
		
		bw.write(sb.delete(sb.length()-1, sb.length()).toString());
		br.close();
		bw.close();
	}

}
