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
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == b && b == c && a == 0) break;
			
			if(a+b <= c || a+c <= b || b+c <= a) {
				sb.append("Invalid").append("\n");
			} else if(a == b && b == c) {
				sb.append("Equilateral").append("\n");
			} else if(a != b && b != c && a != c) {
				sb.append("Scalene").append("\n");
			} else {
				sb.append("Isosceles").append("\n");
			}
			
		}
		
		
		bw.write(sb.delete(sb.length()-1, sb.length()).toString());
		br.close();
		bw.close();
	}

}
