import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int size = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(size --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sb.append(Integer.parseInt(st.nextToken()) < Integer.parseInt(st.nextToken()) ? "NO" : "MMM").append(" BRAINS").append("\n");
		}
		System.out.print(sb);
        br.close();
    }
}