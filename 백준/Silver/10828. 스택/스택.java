
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			} else if(order.equals("top")) {
				if(stack.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(stack.peek())+ "\n");
				}
			} else if(order.equals("size")) {
				bw.write(String.valueOf(stack.size()) + "\n");
			} else if(order.equals("empty")) {
				if(stack.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if(order.equals("pop")) {
				if(stack.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(stack.pop()) + "\n");
				}
			} 
		}
		bw.close();
	}

}
