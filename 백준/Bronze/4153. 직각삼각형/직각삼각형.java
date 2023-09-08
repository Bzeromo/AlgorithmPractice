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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
			
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == b && b == c && c== 0) break;
			
			int max = Math.max(a, Math.max(b, c));
			int min = Math.min(a, Math.min(b, c));
			int sec;
			
			if(a!=max && a!=min)
				sec = a;
			else if(b != min && b != max)
				sec = b;
			else sec = c;
			
			if((sec*sec) + (min*min) == (max*max))
				sb.append("right");
			else
				sb.append("wrong");
			
			sb.append("\n");
		}
		
 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}