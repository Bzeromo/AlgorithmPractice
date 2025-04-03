import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static long A, B, answer = 0;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		br.close();
	}
	
	static void calc() {
		answer = count(B) - count(A - 1);
    }
	
	static void output() {
		System.out.println(answer);
	}
	
	static long count(long N) {
		long res = 0, div = 1;
		
		while(N > 0) {
			if(N % 2 == 0)
				res += N / 2 * div;
			else
				res += (N / 2 + 1) * div;
			
			div *= 2;
			N /= 2;
		}
		
		return res;
	}
}