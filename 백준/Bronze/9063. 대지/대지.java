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
		
		int T = Integer.parseInt(br.readLine());
		int xMax = Integer.MIN_VALUE;
		int xMin = Integer.MAX_VALUE;
		int yMax = Integer.MIN_VALUE;
		int yMin = Integer.MAX_VALUE;
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			xMax = Math.max(xMax, x);
			xMin = Math.min(xMin, x);
			yMax = Math.max(yMax, y);
			yMin = Math.min(yMin, y);
		}
		
		sb.append((xMax-xMin) * (yMax-yMin));
		
		bw.write(sb.toString());
		
		bw.close();
	} // main
} // class
