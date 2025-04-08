import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N;
	static Deque<Integer> deque = new LinkedList<>();
    static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		br.close();
	}
	
	static void calc() {
		for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
		
        while(deque.size() > 1) {
            queue.add(deque.removeFirst());
            deque.addLast(deque.removeFirst());
        }
        
        for(int i : queue) {
            sb.append(i + " ");
        }
        
        sb.append(deque.remove());
    }
	
	static void output() {
		System.out.println(sb);
	}
	
}