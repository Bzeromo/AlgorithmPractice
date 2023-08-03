import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a==0) {
				stack.pop();
				continue;
			}
			else {
				stack.add(a);
			}
		}
		
		T = stack.size();
		for(int i = 0; i < T; i++) {
			ans += stack.pop();
		}
		
		bw.write(String.valueOf(ans));

		bw.close();
	}
}

