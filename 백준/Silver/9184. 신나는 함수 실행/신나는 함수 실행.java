import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int [][][] arr = new int[21][21][21];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			if(a == b && b == c && c == -1)
				break;
			
			sb.append("w(" +a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static int w(int a, int b, int c) {
		if(isPossible(a,b,c) && arr[a][b][c] != 0)
			return arr[a][b][c];
		
		if(a <= 0 || b <= 0 || c <= 0)
			return 1;
		
		if(a > 20 || b > 20 || c > 20) 
			return arr[20][20][20] = w(20, 20, 20);
		
		if(a < b && b < c)
			return arr[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
	
		return arr[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
	
	static boolean isPossible(int a, int b, int c) {
		return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
	}
}
