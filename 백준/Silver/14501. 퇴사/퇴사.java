import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
	static int N, max;
	static int work[], price[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        max = 0;
        work = new int[N+1];
        price = new int[N+1];
       
        for(int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	work[i] = Integer.parseInt(st.nextToken());
        	price[i] = Integer.parseInt(st.nextToken());
        }
        
        solution(1, 0);
        
        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
    
   static void solution(int day, int sum) {
	   if(day == N+1) {
		   max = Math.max(max, sum);
		   return;
	   }
	   
	   if(day > N) return;
	   
	   solution(day + work[day], sum + price[day]);
	   solution(day + 1, sum);
   }
}