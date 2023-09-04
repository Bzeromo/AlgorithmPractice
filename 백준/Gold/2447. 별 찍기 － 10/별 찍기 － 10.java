import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {
	static char[][] arr;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
 
		arr = new char[N][N];
        
		star(0, 0, N, false);
 
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
 
	static void star(int x, int y, int N, boolean blank) {
 
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
 
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { 
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}