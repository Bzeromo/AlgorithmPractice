
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static String [][] war;
	static int N;
	static int M;
	//상하좌우
	static int dc [] = {0, 0, -1, 1};
	static int dr [] = {-1, 1, 0, 0};
	static boolean [][] flag;
	static int mine = 0;
	static int mineAttack = 0;
	static int enemy = 0;
	static int enemyAttack = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		war = new String [M][N];
		flag = new boolean [M][N];
		
		for(int i = 0; i < M; i++) {
			String [] line = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				war[i][j] = line[j];
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!flag[i][j]) {
					dfs(war[i][j], j, i);
					if(war[i][j].equals("B")) {
						enemyAttack += enemy * enemy;
						enemy = 0;
					} else {
						mineAttack += mine * mine;
						mine = 0;
					}
				}
			}
		}
		
		bw.write(String.valueOf(mineAttack) + " " + String.valueOf(enemyAttack));
		bw.close();
		br.close();
	}
	
	static void dfs(String soldier, int x, int y) {
		flag[y][x] = true;
		if(soldier.equals("W")) mine++;
		else enemy++;
		
		for(int i = 0; i < 4; i++) {
			int dx = x + dc[i];
			int dy = y + dr[i];
			
			if(isRange(dy, dx) && !flag[dy][dx] && war[dy][dx].equals(soldier)) {
				dfs(soldier, dx, dy);
			}
		}
	}

	public static boolean isRange(int nr ,int nc) {
		return !(nr < 0 || nr >= M || nc < 0 || nc >= N);
	}
}