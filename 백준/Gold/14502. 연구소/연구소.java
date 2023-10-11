import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans = Integer.MIN_VALUE;
	static int [][] map, copyMap;
	// 시계방향 (상 우 하 좌)
	static int dr [] = {-1, 0, 1, 0};
	static int dc [] = {0, 1, 0, -1};
	static boolean [][] visited;
	
	//배열 복사 메서드
	public static int[][] copy(int[][] src) {
        if (src == null) {
            return null;
        }
 
        int[][] copy = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = Arrays.copyOf(src[i], src[i].length);
        }
 
        return copy;
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N+2][M+2];
		visited = new boolean[N+2][M+2];
		
		Arrays.fill(map[0], 1);
		Arrays.fill(map[N+1], 1);
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 1);
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		build(1, 1, 0);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	static void virus (int x, int y) {		
		if(x == N + 1 || y == M + 1 || x < 1 || y < 1)
			return;
		
		copyMap[x][y] = 2;
		
		//사방향 델타 탐색
		for(int i = 0; i < 4; i++) {
			int r = x + dr[i];
			int c = y + dc[i];
			
			if(copyMap[r][c] == 1 || copyMap[r][c] == 2)
				continue;
			
			virus(r, c);
		}
	}
	
	static void build (int x, int y, int cnt) {
		if(cnt == 3) {
			int n = 0;
			
			copyMap = copy(map);
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(visited[i][j]) {
						copyMap[i][j] = 1;
					}
				}
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(map[i][j] == 2) {
						virus(i, j);
					}
				}
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(copyMap[i][j] == 0) {
						n++;
					}
				}
			}
			
			ans = Math.max(ans, n);
			return;
		}
		
		if(x == N + 1) {
			build(x - N, y+1, cnt);
			return;
		}
		
		if(y == M + 1) 
			return;
		
		if(map[x][y] == 0) {
			visited[x][y] = true;
			build(x + 1, y, cnt + 1);
			visited[x][y] = false;
		}
		
		build(x + 1, y, cnt);
	}
}
