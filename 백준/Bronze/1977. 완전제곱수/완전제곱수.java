import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());  
        int n = Integer.parseInt(br.readLine());  
        
        int min = Integer.MAX_VALUE;    
        int sum = 0;  
        
        for (int i = 1; i*i <= n; i++) {
            if (i * i >= m && i * i <= n) { 
                min = Math.min(i*i, min);
                sum += i*i;
            }
        }
        
        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum + "\n" + min);
        }
    }
}