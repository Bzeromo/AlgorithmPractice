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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				stack.add(b);
			} else if (a==2) {
				if(!(stack.isEmpty()))
					bw.write(String.valueOf(stack.pop()) + "\n");
				else bw.write("-1\n");
			} else if (a==3) {
				bw.write(String.valueOf(stack.size()) + "\n");
			} else if (a==4) {
				if(!(stack.isEmpty()))
					bw.write("0\n");
				else bw.write("1\n");
			} else {
				if(!(stack.isEmpty()))
					bw.write(String.valueOf(stack.peek()) + "\n");
				else bw.write("-1" + "\n");
			}
		}

		bw.close();
	}
}

