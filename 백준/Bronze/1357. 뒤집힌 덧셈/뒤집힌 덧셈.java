import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(st.nextToken());
        
		String A = sb.reverse().toString();
		sb = new StringBuilder(st.nextToken());
		String B = sb.reverse().toString();
	
		int sum = Integer.parseInt(A) + Integer.parseInt(B);
		sb = new StringBuilder(String.valueOf(sum));
		String result = sb.reverse().toString();
		
		System.out.println(Integer.parseInt(result));
        br.close();
	}

}