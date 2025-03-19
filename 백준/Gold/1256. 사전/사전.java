import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        StringBuilder result = new StringBuilder();
        
        long[][] DP = new long[N+M+1][N+M+1];
        DP[0][0] = 1;
        
        for(int i=1;i<=N+M;i++){
            DP[i][0] = 1;
            DP[i][i] = 1;
            for(int j=1;j<i;j++){
                DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
                if(DP[i][j] > 1000000000){
                    DP[i][j] = 1000000001;
                }
            }
        }

        if(DP[N+M][N] < K){
            bw.write("-1");
        }else{
            while (N != 0 || M != 0) {
                if (DP[N + M - 1][M] >= K) {
                    result.append("a");
                    N--;
                } else {
                    result.append("z");
                    K -= DP[N + M - 1][M];
                    M--;
                }
            }
        }
        
        bw.write(result.toString());
        bw.close();
        br.close();
    }
}