import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int res [], num [];
	static boolean [] flag;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int [N+1];
		res = new int [N+1];
		flag = new boolean[N+1];
		
		for(int i = 0; i < N; i++) {
			num[i] = i+1;
		}
		
		comb(0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void comb(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(flag[i]) continue;
			flag[i] = true;
			res[idx] = i;
			comb(idx+1);
			flag[i] = false;
		}
	}
}
