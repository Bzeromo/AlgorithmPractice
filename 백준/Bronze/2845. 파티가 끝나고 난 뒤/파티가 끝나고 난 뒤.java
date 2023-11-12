import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int human = N * M;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) {
			sb.append(Integer.parseInt(st.nextToken()) - human).append(" ");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	
}