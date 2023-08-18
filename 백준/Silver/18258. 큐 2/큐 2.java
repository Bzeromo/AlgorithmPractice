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
		int T = Integer.parseInt(br.readLine());
		Queue <Integer> queue = new LinkedList<>();
		int back = 0;
		
		while(T-- !=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			if(order.equals("push")) {
				back = Integer.parseInt(st.nextToken());
				queue.add(back);
			} else if(order.equals("front")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(queue.peek()) + "\n");
				}
			} else if(order.equals("back")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(back)+ "\n");
				}
			} else if(order.equals("empty")) {
				if(queue.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if(order.equals("pop")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(queue.poll())+ "\n");
				}
			} else if(order.equals("size")) {
				bw.write(String.valueOf(queue.size())+ "\n");
			} 	
		}
		bw.close();
	} // main
} // class
