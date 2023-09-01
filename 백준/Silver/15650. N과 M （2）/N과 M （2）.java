import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int res [], num [];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int [M];
		num = new int [N];
		
		for(int i = 0; i < N; i++) {
			num[i] = i+1;
		}
		
		comb(0, 0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void comb(int idx, int sidx) {
		if(sidx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i <= N-M+sidx; i++) {
			res[sidx] = num[i];
			comb(i+1, sidx+1);
		}
	}
}
