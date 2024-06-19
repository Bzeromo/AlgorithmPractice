import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            int n,m,cnt = 0;
            HashSet <Integer> hs = new HashSet<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            // 소인수 개수를 저장할 dp 리스트
            int [] dp = new int[m + 1];
            
            // 에라토스테네스의 체를 위해 필요한 boolean 리스트
            boolean [] oTable = new boolean[m + 1];
            
            // 에라토스테네스의 체
            Arrays.fill(oTable, true);
            for(int i = 2; i <= m; i ++){
                if(oTable[i] == true){
                    hs.add(i);
                    int cur = i * 2;
                    while(cur <= m){
                        oTable[cur] = false;
                        cur += i;
                    }
                }
            }
            
            // DP 업데이트
            for(int i = 2; i <= m; i ++) {
                for (Integer j : hs) {
                    if(i % j == 0){
                        dp[i] = dp[i / j] + 1;
                        break;
                    }
                }
            }
            for (int i = n; i <= m; i++) {
                if(hs.contains(dp[i])){
                    cnt++;
                }
            }
            System.out.println(cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}