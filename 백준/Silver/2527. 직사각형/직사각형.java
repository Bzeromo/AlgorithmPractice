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
		
		for(int tc = 1; tc <= 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
		
			if(isOther(x, y, p, q, x2, y2, p2, q2))
				sb.append("d");
			else if(isDot(x, y, p, q, x2, y2, p2, q2))
				sb.append("c");
			else if(isLine(x, y, p, q, x2, y2, p2, q2))
				sb.append("b");
			else
				sb.append("a");
			
			sb.append("\n");
		}
		
		bw.write(sb.delete(sb.length()-1, sb.length()-1).toString());
		
		bw.close();
	} // main
	
	static boolean isOther (int x, int y, int p, int q, int x2, int y2, int p2, int q2) {
		return p2 < x || q2 < y || p < x2 || q < y2;
	}
	
	static boolean isDot (int x, int y, int p, int q, int x2, int y2, int p2, int q2) {
		return (x==p2 && y==q2) || (p==x2 && q==y2) || (y==q2 && p==x2) || (q==y2 && x==p2);
	}
	
	static boolean isLine (int x, int y, int p, int q, int x2, int y2, int p2, int q2) {
		return p==x2 || q==y2 || x==p2 || q2==y;
	}
} // class
