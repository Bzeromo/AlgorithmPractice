import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int count = 1;
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < T; i++) {
			stack2.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < T; i++) {
			stack.add(stack2.pop());
		}
		
		for(int i = 0; i < T; i++) {
			if(!stack2.isEmpty()) {
				if(stack2.peek() == count) {
					stack2.pop();
					count++;
					i--;
					continue;
				}
			}
			
			int a = stack.pop();
			
			if(a == count) {
				count++;
				continue;
			}
			else stack2.add(a);
		}
		
		T = stack2.size();
		
		for(int i = 0; i < T; i++) {
			int a = stack2.pop();
			
			if(a == count) {
				count++;
				continue;
			}
			else break;
		}
		
		if(stack2.isEmpty())
			bw.write("Nice");
		else
			bw.write("Sad");

		bw.close();
	}
}

