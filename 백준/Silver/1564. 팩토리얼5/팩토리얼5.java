import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static long N, num = 1, k = (long)1e12;
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
		for(long i = 1; i <= N; i++) {
            num *= i;
            
            while(num%10==0) {
            	num /= 10;
            }
            
            num %= k;
        }
		
		num %= 100000;
		
        if(num < 10000 || num < 1000 || num < 100 || num < 10)
        	sb.append(0);
        
        sb.append(num);
    }
	
	static void output() {
		System.out.println(sb);
	}
}