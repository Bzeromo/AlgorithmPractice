import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		
		String str [] = br.readLine().split("");
		sb.append("*");
		for(int i = 0; i<N; i++) {
			if(str[i].equals("S"))
				sb.append("S*");
			else if(str[i].equals("L")) {
				sb.append("LL*");
				i++;
			}
		}
		
		for(int i = 0; i < sb.length(); i++) {
			char s = sb.charAt(i);
			if(s == '*') {
				cnt++;
			}
		}
		
		if(cnt > N) 
			bw.write(String.valueOf(N));
		else
			bw.write(String.valueOf(cnt));
		
		bw.close();
	} // main
	
} // class
