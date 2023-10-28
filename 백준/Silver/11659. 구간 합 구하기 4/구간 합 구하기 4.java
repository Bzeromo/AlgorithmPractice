import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr [] = new int[N+1];
		int sum [] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		arr[0] = 0;
		sum[0] = 0;
		
		for(int i =1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i] + sum[i-1];
		}
		
		for(int i = 0; i < M; i++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n != m)
				ans = sum[m] - sum[n-1];
			else
				ans = arr[m];
			
			sb.append(ans).append("\n");
		}

		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
