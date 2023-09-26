import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int [][] screen;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int N = Integer.parseInt(br.readLine());
		 
		 screen = new int [N][N];
		
		 String s;
		 
		 for(int i = 0; i < N; i++) {
			 s = br.readLine();
			 for(int j = 0; j < N; j++) {
				 screen[i][j] = s.charAt(j) - '0'; 
			 }
		 }
		 
		 quadTree(0, N, 0, N, N);
		 bw.write(sb.toString());
		 br.close();
		 bw.close();
	}
	
	static void quadTree(int stX, int edX, int stY, int edY, int N) {
		if(edX < 0 || edY < 0) return;
		
		int dot = screen[stX][stY];
		
		for(int i = stX; i < edX; i++) {
			for(int j = stY; j < edY; j++) {
				 if(screen[i][j] != dot) {
					 sb.append("(");
					 quadTree(stX, edX - N/2, stY, edY - N/2, N/2);
					 quadTree(stX, edX - N/2, stY + N/2, edY, N/2);
					 quadTree(stX + N/2, edX, stY, edY - N/2, N/2);
					 quadTree(stX + N/2, edX, stY + N/2, edY, N/2);
					 sb.append(")");
					 return;
				 }
			 }
		}
		sb.append(dot);
	}
}