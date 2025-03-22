import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int C = Integer.parseInt(br.readLine());
       
      int[] count = new int[1001];
      count[1] = 3;
      int tmp;
       
      for(int i = 2; i < 1001; i++){
         tmp = 0;
         for(int j=1;j<i;j++){
            if(gcd(i,j)==1) tmp++;
         }
         count[i] = count[i-1] + tmp*2;
      }
 
      StringBuilder sb = new StringBuilder();
       
      for(int i = 0; i < C; i++){
         sb.append(count[Integer.parseInt(br.readLine())]).append('\n');
      }
      System.out.println(sb);
      br.close();
   }
    
   public static int gcd(int a, int b){
      if(b==0) return a;
      return gcd(b,a%b);
   }
}