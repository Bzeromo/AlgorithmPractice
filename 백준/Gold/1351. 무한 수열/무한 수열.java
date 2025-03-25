import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static long N, P, Q;
	static Map<Long, Long> map = new HashMap<>();
	
	public static void solve() throws IOException {
		input();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		br.close();
	}
	
	static void output() {
		System.out.println(calc(N));
	}
	
	static long calc(long N) {
		if(N == 0) return 1;
		
		if(map.containsKey(N)) return map.get(N);
		
		map.put(N, calc((long)Math.floor(N/P))+calc((long)Math.floor(N/Q)));
		
        return map.get(N);
	}
}