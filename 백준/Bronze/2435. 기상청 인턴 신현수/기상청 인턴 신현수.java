import java.io.*;
import java.util.*;

public class Main {
	static int[] temp=new int[103];
	static int n,k,max=Integer.MIN_VALUE;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i <= n-k; i++) {
            int now = 0;
            for(int j = 0; j < k; j++) {
                now += arr[i+j];
            }
            if(now > max) {
                max = now;
            }
        }
        
        System.out.println(max);
        br.close();
	}

}