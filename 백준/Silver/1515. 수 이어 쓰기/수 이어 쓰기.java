import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static String str, answer;
	static int p, b;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		br.close();
	}
	
	static void calc() {
		while(b++ <= 30000) {
            String temp = String.valueOf(b);

            for(int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i) == str.charAt(p))
                    p++;
                

                if (p == str.length()) { 
                    answer = String.valueOf(b);
                    return;
                }
            }
        }
    }
	
	static void output() {
		System.out.println(answer);
	}
	
}

