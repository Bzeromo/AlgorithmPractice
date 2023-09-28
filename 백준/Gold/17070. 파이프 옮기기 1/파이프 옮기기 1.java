import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {    
	static int M, cnt;	
	static boolean visited[];
	static int home[][];
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		M = Integer.parseInt(br.readLine());
		home = new int [M+2][M+2];
		visited = new boolean[M+2];
		
		for(int i = 0; i < M+2; i++) {
			Arrays.fill(home[i], 1);
		}
		
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		
		pipe(1, 2, 1);
		
		bw.write(String.valueOf(cnt));
		br.close();		
		bw.close();
    }
    static void pipe (int x, int y, int dir) {
    	if(x > M || y > M || home[x][y] == 1) return;
    	
    	if(x == M && y == M) {
    		cnt++;
    		return;
    	}
    	
    	if(dir == 1) {
    		if(home[x+1][y] != 1 && home[x][y+1] != 1)
        		pipe(x+1, y+1, 3);
    		
    		pipe(x, y+1, 1);
    	}
    	else if(dir == 2) {
    		if(home[x+1][y] != 1 && home[x][y+1] != 1)
        		pipe(x+1, y+1, 3);
    		
    		pipe(x+1, y, 2);
    	}
    	else {
    		if(home[x+1][y] != 1 && home[x][y+1] != 1)
        		pipe(x+1, y+1, 3);
    		
    		pipe(x+1, y, 2);
    		pipe(x, y+1, 1);
    	}
    	
    }
    
}