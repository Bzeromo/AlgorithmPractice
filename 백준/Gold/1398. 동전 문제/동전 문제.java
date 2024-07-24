import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int n = Integer.parseInt(br.readLine());
		int[] dp= new int[100];
        
		for(int i=0;i<100;i++) {
			if(i>=25) {
				dp[i]=Math.min(dp[i-25]+1, dp[i-10]+1);
				dp[i]=Math.min(dp[i],dp[i-1]+1);
			}else if(i>=10) {
				dp[i]=Math.min(dp[i-10]+1, dp[i-1]+1);
			}else {
				dp[i]=i;
			}
		}
		
		for (int i = 0; i < n; i++) {
			Long num = Long.parseLong(br.readLine());
			int result=0;
			while(num>0) {
				result+=dp[(int) (num%100)];
				num/=100;
			}
			bw.write(String.valueOf(result + "\n"));
		}
        
        bw.close();
        br.close();
	}

}