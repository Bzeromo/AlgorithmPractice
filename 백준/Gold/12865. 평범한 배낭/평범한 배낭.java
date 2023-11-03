import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());//물건의 개수
		int W = Integer.parseInt(st.nextToken()); //가방의 무게
		
		int [] weights = new int [N+1];
		int [] cost = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int [][] dp = new int [N+1][W+1];
		//물건을 하나도 고려하지 않았을 때는 이미 0으로 초기화 되어있음
		//물건을 하나씩 고려하면서 처리
		for(int i = 1; i <= N; i++) {
			//i번째 물건까지 고려를 한 경우가 저장
			//w: 임시 배낭의 크기
			for(int w = 0; w <= W; w++) {
				if(weights[i] <= w) {
					//해당물건 판단
					//현재 해당 무게에서의 최적해는 dp[i-1][w]
					//이번에 물건을 고려한 최적해는 dp[i-1][w-weights[i]] + cost[i]
					//위의 두가지의 경우 중 베스트 값을 현재 저장
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + cost[i]);
				} else {
					dp[i][w] = dp[i-1][w]; //현재 고려할 물건의 무게가 임시무게를 벗어나 고려할 수 없을 때
				}
			}
		}
		
		bw.write(String.valueOf(dp[N][W]));
		br.close();
		bw.close();
	}
	
}