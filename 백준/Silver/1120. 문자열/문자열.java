import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static String A, B;
	static int answer = 50;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();
		B = st.nextToken();
		
		br.close();
	}
	
	static void calc() {
		for(int i = 0; i <= (B.length() - A.length()); i++) {
			int count = 0;
			
			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.charAt(j + i)) {
					count++;
				}
			}
			
			answer = Math.min(answer, count);
		}
    }
	
	static void output() {
		System.out.println(answer);
	}
	
}

