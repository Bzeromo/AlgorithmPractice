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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] [] one = new int[N][M];
		int [] [] two = new int[N][M];
		int [] [] sum = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				one[i][j] = Integer.parseInt(st2.nextToken()); 
			}
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				two[i][j] = Integer.parseInt(st2.nextToken()); 
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sum[i][j] = one[i][j] + two[i][j]; 
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write(String.valueOf(sum[i][j]) + " ");
			}
			bw.write("\n");
		}
		
		bw.close();
	}
}

