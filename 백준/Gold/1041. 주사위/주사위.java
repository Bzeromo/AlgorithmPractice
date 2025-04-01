import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static long N, answer, one = Long.MAX_VALUE, two = Long.MAX_VALUE, three = 0, max = 0, sum = 0;
	static long arr[] = new long [6];
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	static void calc() {
		for (int i = 0; i < 6; i++) {
			one = Math.min(one, arr[i]);
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i + j != 5 && i != j)
					two = Math.min(two, arr[i] + arr[j]);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			three += Math.min(arr[i], arr[5 - i]);
		}
		
		if (N == 1) {
			answer = sum - max;
		} else {
			answer = three * 4 + two * (4 * (N - 1) + 4 * (N - 2)) + one * ((N - 2) * (N - 1) * 4 + (N - 2) * (N - 2));
		}
    }
	
	static void output() {
		System.out.println(answer);
	}
}