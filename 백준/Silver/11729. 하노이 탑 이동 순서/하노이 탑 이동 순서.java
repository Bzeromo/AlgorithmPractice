import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	static Stack<Integer> firstTop, secondTop, thirdTop;
	static int N, cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		firstTop = new Stack<>();
		secondTop = new Stack<>();
		thirdTop = new Stack<>();
		
		for(int i = N; i >= 1; i--) {
			firstTop.add(i);
		}
		
		hanoi(N, firstTop, thirdTop, secondTop, 1, 3, 2);
		
		bw.write(String.valueOf(cnt) + "\n" + sb.toString());
		br.close();
		bw.close();
	}
	
	static void hanoi(int n, Stack<Integer> first, Stack<Integer> third, Stack<Integer> second, int f, int t, int s) {
		if(N == thirdTop.size())
			return;
		if(n == 1) 
			move(first, third, f, t);
		else {
			hanoi(n-1, first, second, third, f, s, t);
			move(first, third, f, t);
			hanoi(n-1, second, third, first, s, t, f);
		}
	}
	
	static void move(Stack<Integer> first, Stack<Integer> third, int f, int t) {
		third.add(first.pop());
		sb.append(f).append(" ").append(t).append("\n");
		cnt++;
	}
}
