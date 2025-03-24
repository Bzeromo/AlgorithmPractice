import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N;
	static int arr[];
	static int max = Integer.MIN_VALUE;
	static boolean visited[];
	
	public static void solve() throws IOException {
		input();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	static void output() {
		for(int i = 0; i < N; i++) {
			calc(1, i, 0, arr[i]);
		}
		
		System.out.print(max);
	}
	
	static void calc(int t, int index, int sum, int temp) {
		if(t == N) {
			max = Math.max(max, sum);
			return;
		}
		
		visited[index] = true;
		
		for(int i = 0; i < N; i++) {
			if (!visited[i]) {
				calc(t + 1, i, sum + Math.abs(temp - arr[i]), arr[i]);
			}
		}
		
		visited[index] = false;
	}
}