import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans = Integer.MAX_VALUE, c;
	static int [][] map, copyMap;
	// 시계방향 (상 우 하 좌)
	static int dr [] = {-1, 0, 1, 0};
	static int dc [] = {0, 1, 0, -1};
	static boolean [][] visited;
	
	static class Virus {
		int x, y, cnt;
		
		Virus(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
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
		
		map = new int [N+2][N+2];
		visited = new boolean[N+2][N+2];
		
		Arrays.fill(map[0], 1);
		Arrays.fill(map[N+1], 1);
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 1);
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		build(1, 1, 0);
		
		bw.write(String.valueOf(ans != Integer.MAX_VALUE ? ans : -1));
		br.close();
		bw.close();
	}
	
	static void build (int x, int y, int cnt) {
		if(cnt == M) {
			int ct = 0;
			c = 0;
			Queue<Virus> q = new LinkedList<>();
			copyMap = copy(map);
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(visited[i][j]) {
						copyMap[i][j] = 3;
						q.add(new Virus(i, j, ct));
					}
				}
			}
			
			while(!q.isEmpty()) {
				Virus tmp = q.poll();
				
				c = Math.max(c, tmp.cnt);
				ct = tmp.cnt + 1;
				
				//사방향 델타 탐색
				for(int i = 0; i < 4; i++) {					
					int r = tmp.x + dr[i];
					int c = tmp.y + dc[i];
					
					if(!isPossible(r, c) || copyMap[r][c] == 1 || copyMap[r][c] == 3)
						continue;
		
					copyMap[r][c] = 3;
					q.add(new Virus(r, c, ct));
				}
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(copyMap[i][j] == 0 || copyMap[i][j] == 2) {
						return;
					}
				}
			}
			
			ans = Math.min(c, ans);
			return;
		}
		
		if(x == N + 1) {
			build(x - N, y+1, cnt);
			return;
		}
		
		if(y == N + 1) 
			return;
		
		if(map[x][y] == 2) {
			visited[x][y] = true;
			build(x + 1, y, cnt + 1);
			visited[x][y] = false;
		}
		
		build(x + 1, y, cnt);
	}
	
	static boolean isPossible(int x, int y) {
		return x <= N && x > 0 && y <= N && y > 0;
	}
}
