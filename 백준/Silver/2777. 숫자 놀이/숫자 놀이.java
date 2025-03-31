import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void solve() throws IOException {
		inputAndCalc();
		output();
	}
	
	static void inputAndCalc() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			calc(n);
		}
		
		br.close();
	}
	
	static void calc(int n) {
		int idx = 9, answer = 0;
		
		if (n == 1) {
			sb.append("1" + "\n");
			return;
		}
		while (idx > 1) {
			if (n % idx == 0) {
				n /= idx;
				answer += 1;
			} else {
				idx -= 1;
			}
		}
		if (n != 1) {
			sb.append("-1" + "\n");
		} else {
			sb.append(String.valueOf(answer) + "\n");
		}
    }
	
	static void output() {
		System.out.println(sb);
	}
}