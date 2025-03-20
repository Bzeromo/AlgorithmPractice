import java.io.*;
import java.util.*;
 
public class Main {
    static int c, n;
    static int [] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
 
        dp = new int [c+101];
        Arrays.fill(dp,987654321);
        dp[0] = 0;
 
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            
            for(int j=people; j<c+101; j++){
                dp[j] = Math.min(dp[j],cost+dp[j-people]);
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int i = c; i < c + 101; i++){
            result = Math.min(result, dp[i]);
        }
        
        System.out.println(result);
        br.close();
    }
}