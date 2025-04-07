import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int R, G, N;
	
	public static void solve() throws IOException {
		input();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		br.close();
	}
	
	static int calc(int R, int G) {
		if (G == 0) {
			return R;
		}
		return calc(G, R % G);
    }
	
	static void output() {
		N = calc(R, G);
		
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				System.out.println(i + " " + R / i + " " + G / i);
				if (N / i != i)
					System.out.println(N / i + " " + R / (N / i) + " " + G / (N / i));
			}
		}
	}
	
}