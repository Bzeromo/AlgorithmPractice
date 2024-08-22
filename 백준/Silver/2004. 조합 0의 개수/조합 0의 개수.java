import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int twoCnt = get(n, 2) - get(m, 2) - get(n - m, 2);
        int fiveCnt = get(n, 5) - get(m, 5) - get(n - m, 5);
        
        System.out.println(Math.min(twoCnt, fiveCnt));
    }
    
    private static int get(int n, int k) {
        int cnt = 0;
        
        while(n >= k) {
            cnt += n / k;
            n /= k;
        }
        
        return cnt;
    }
}
 