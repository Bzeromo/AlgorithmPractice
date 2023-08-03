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
		int [][] arr = new int[100][100];
		
		for(int i = 0; i < paper; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j = a; j < 10+a; j++) {
				for(int k = b; k < 10+b; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int ans = 0;
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				ans += arr[j][k];
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.close();
	}
}

