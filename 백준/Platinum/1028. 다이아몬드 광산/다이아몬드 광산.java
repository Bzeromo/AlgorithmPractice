import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M, map[][];
    static int dp[][][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[750][750];   
        dp = new int[750][750][4]; 
        
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }          
        if (N == 1 && M == 1) {
            System.out.println(map[0][0]);
            return;
        }
        
        int maxSize = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1) {
                    for (int d=0; d<4; d++) {
                        dp[i][j][d] = getSize(i, j, d);
                    }
                    
                    if (dp[i][j][2] > maxSize && dp[i][j][3] > maxSize) {
                        int len = Math.min(dp[i][j][2], dp[i][j][3])-1;
                        
                        for (int tmpLen=len; tmpLen>=maxSize; tmpLen--) {
                            if (i-(2*tmpLen) < 0) 
                                continue;
                            
                            if (dp[i-(2*tmpLen)][j][0] > tmpLen && dp[i-(2*tmpLen)][j][1] > tmpLen) {
                                maxSize = tmpLen+1;
                                break;
                            }
                        }
                    }
                }
            }
        }        
        
        
        System.out.println(maxSize);
    }
    
    public static int getSize(int x, int y, int d) {
        int size = 0;
        
        int dx = 0;
        int dy = 0;
        
        while (true) {
            int nx = x + dx;
            int ny = y + dy;
            
            if (d == 0) {        
                dx++;
                dy--;
            } else if (d == 1) { 
                dx++;
                dy++;
            } else if (d == 2) { 
                dx--;
                dy--;
            } else if (d == 3) {
                dx--;
                dy++;
            }
            
            if (nx < 0 || ny < 0 || nx > N-1 || ny > M-1 || map[nx][ny] == 0) break;
            size++;
        }
        
        return size;
    }
}