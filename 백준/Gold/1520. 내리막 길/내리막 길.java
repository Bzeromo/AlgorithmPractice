import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] arr, dp;
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[M + 1][N + 1]; 
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		bw.write(DFS(1, 1) + "\n");
		bw.close();
		br.close();
	}

	public static int DFS(int x, int y) {
		if (x == M && y == N) {
			return 1;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0; 
		for (int i = 0; i < 4; i++) {
			int dx = x + rangeX[i];
			int dy = y + rangeY[i];

			if (dx < 1 || dy < 1 || dx > M || dy > N) {
				continue;
			}
			
			if (arr[x][y] > arr[dx][dy]) {
				dp[x][y] += DFS(dx, dy);
			}
		}

		return dp[x][y];
	}

}