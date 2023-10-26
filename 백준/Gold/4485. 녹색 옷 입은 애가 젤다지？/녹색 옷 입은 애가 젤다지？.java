import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {    
	static final int INF = Integer.MAX_VALUE;
	static int N, tc = 1;
	//상하좌우
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int cave [][];
	static int dist [][];
	static boolean visited [][];
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while((N = Integer.parseInt(br.readLine())) != 0) {
			cave = new int [N][N];
			visited = new boolean [N][N];
			dist = new int [N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dist[0][0] = cave[0][0];
			
			for(int i = 0; i < N*N-1; i++) {
				int min = INF;
				int Xidx = -1;
				int Yidx = -1;
				
				for(int j= 0; j < N; j++) {
					for(int k = 0; k < N; k++) {
						if(!visited[j][k] && min > dist[j][k]) {
							min = dist[j][k];
							Xidx = j;
							Yidx = k;
						}
					}
				}
				if(Xidx == -1) break;
				
				visited[Xidx][Yidx] = true;
				
				for(int j = 0; j < 4; j++) {
					int nx = Xidx + dr[j];
					int ny = Yidx + dc[j];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if(!visited[nx][ny] && dist[nx][ny] > dist[Xidx][Yidx] + cave[nx][ny]) {
						dist[nx][ny] = dist[Xidx][Yidx] + cave[nx][ny];
					}
				}
			}
			sb.append("Problem ").append(tc++).append(": ").append(dist[N-1][N-1]).append("\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
    }
    


}