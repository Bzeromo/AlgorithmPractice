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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s;
		
		while(!(s = st.nextToken()).equals("#")) {
			sb.append(s).append(" ");
			
			if(Integer.parseInt(st.nextToken()) > 17) {
				sb.append("Senior").append("\n");
			} else if(Integer.parseInt(st.nextToken()) >= 80) {
				sb.append("Senior").append("\n");
			} else {
				sb.append("Junior").append("\n");
			}
			
			st = new StringTokenizer(br.readLine());
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	
}
