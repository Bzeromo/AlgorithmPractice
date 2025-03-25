import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, M, length = 0;
	static String arr[];
	
	public static void solve() throws IOException {
		input();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			length += arr[i].length();
		}
		
		br.close();
	}
	
	static void output() {
		System.out.println(makeWord());
	}
	
	static String makeWord() {
        int total = M - length;
        int min = total / (N-1);
        int extra = total % (N-1);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < N; i++) {
        	if(arr[i].charAt(0) <= 'z' && arr[i].charAt(0) >= 'a') {
        		int under = min + (extra > 0 ? 1 : 0);
                extra--;
                arr[i] = "_".repeat(under) + arr[i];
        	}
        }
        
        for (int i = N-1; i > 0; i--) {
        	if(arr[i].charAt(0) != '_') {
        		int under = min + (extra > 0 ? 1 : 0);
                extra--;
                arr[i] = "_".repeat(under) + arr[i];
        	}
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
	}
}