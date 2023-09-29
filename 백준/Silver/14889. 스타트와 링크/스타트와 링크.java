import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static int N, ans;
	static int start[], link[], synergy[][];
	static boolean select[];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        synergy = new int [N][N];
        select = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		synergy[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        start = new int[N/2];
        link = new int[N/2];
        ans = Integer.MAX_VALUE;
        
       solution(0, 0);
        
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
    
   static void solution(int idx, int sidx) {
	   if(sidx == N/2) {
		   int cnt = 0, startSum = 0, linkSum = 0;
		   loop: for(int i = 0; i < N; i++) {
			   for(int j = 0; j < N/2; j++) {
				   if(i == start[j])
					   continue loop;
			   }
			   link[cnt++] = i;
		   }
		   
		   for(int i = 0; i < N/2-1; i++) {
			   for(int j = i+1; j < N/2; j++) {
				   startSum += synergy[start[i]][start[j]] + synergy[start[j]][start[i]];
				   linkSum += synergy[link[i]][link[j]] + synergy[link[j]][link[i]];
			   }
		   }
		   
		   ans = Math.min(ans, Math.abs(startSum - linkSum));
		   return;
	   }
	   if(idx == N) return;
	   
	   start[sidx] = idx;
	   solution(idx + 1, sidx + 1);
	   solution(idx + 1, sidx);
   }
}