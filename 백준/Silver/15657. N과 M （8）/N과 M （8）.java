import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int set [];
	static int ans [];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			set[i] = Integer.parseInt(st.nextToken());
		}	
		
		Arrays.sort(set);
		
		solution(0, 0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void solution(int idx, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(set[i] >= set[idx]) {
				ans[cnt] = set[i];
				solution(i, cnt+1);
			}
		}

	}
}
