import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
       
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      char[][] A = new char[N][M];
      char[][] B = new char[N][M];
      for(int i=0;i<N;i++) A[i] = in.readLine().replace(" ","").toCharArray();
      for(int i=0;i<N;i++) B[i] = in.readLine().replace(" ","").toCharArray();
 
      int answer = 0;
      for(int i=0;i<=N-3;i++){
         for(int j=0;j<=M-3;j++){
            if(A[i][j] != B[i][j]){
               answer++;
               for(int ni=i;ni<i+3;ni++){
                  for(int nj=j;nj<j+3;nj++){
                     if(A[ni][nj]=='0') A[ni][nj] = '1';
                     else A[ni][nj] = '0';
                  }
               }
            }
         }
      }
 
      for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
            if(A[i][j] != B[i][j]) {
               answer = -1;
               break;
            }
         }
      }
 
      System.out.println(answer);
   }
}