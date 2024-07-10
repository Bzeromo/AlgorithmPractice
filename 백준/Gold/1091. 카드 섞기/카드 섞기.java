import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
      int N = Integer.parseInt(br.readLine());
      int[] p = new int[N];
      int[] order = new int[N];
      int[] cards = new int[N];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++) p[i] = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++) {
         order[Integer.parseInt(st.nextToken())] = i;
         cards[i] = i%3;
      }
 
      int[] compare = cards.clone();
      int[] next = new int[N];
      int result = 0;
       
      while(!Arrays.equals(cards,p) && !(result !=0 && Arrays.equals(cards, compare))) {
         for(int j = 0; j < N; j++) {
             next[order[j]] = cards[j];
         }
         cards = next.clone();
         result++;
      }
   
      if(result !=0 && Arrays.equals(cards, compare)) 
          bw.write(String.valueOf(-1));
      else 
          bw.write(String.valueOf(result));
       
      bw.close();
      br.close();
   }
}