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
		
		int paper = Integer.parseInt(br.readLine());
		int board [][] = new int [101][101];
		
		for(int tc = 1; tc <= paper; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
		
			for(int i = x; i < x+w; i++) {
				for(int j = y; j < y+h; j++) {
					board[i][j] = tc;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= paper; tc++) {
			int count = 0;
			for(int i = 0; i < 101; i++) {
				for(int j = 0; j < 101; j++) {
					if(board[i][j] == tc) count++;
				}
			}
			sb.append(count).append("\n");
		}
		
		bw.write(sb.delete(sb.length()-1, sb.length()-1).toString());
		
		bw.close();
	} // main
} // class
