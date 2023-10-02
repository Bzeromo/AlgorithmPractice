import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans, score;
	static int board[][];
	static int dr [] = {-1, 1, 0, 0};
	static int dc [] = {0, 0, -1, 1};
	static boolean visited[][];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int [N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        score = 0;
        visited = new boolean [N][M];
        ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		visited[i][j] = true;
        		solution(i, j, board[i][j], 1);
        		visited[i][j] = false;
        	}
        }
        
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
    
    static void solution(int x, int y, int score, int idx) {
    	if(idx == 4) {
    		ans = Math.max(ans, score);
    		return;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		int curRow = x + dr[i];
    		int curCol = y + dc[i];
    		
    		if(isPossible(curRow, curCol) && !visited[curRow][curCol]) {
    			if(idx == 2) {
    				visited[curRow][curCol] = true;
        			solution(x, y, score + board[curRow][curCol], idx+1);
        			visited[curRow][curCol] = false;
        		}
    			
    			visited[curRow][curCol] = true;
    			solution(curRow, curCol, score + board[curRow][curCol], idx+1);
    			visited[curRow][curCol] = false;
    		}
    	}
    }
   
    static boolean isPossible (int x, int y) {
    	return x < N && x >= 0 && y < M && y >= 0;
    }
}