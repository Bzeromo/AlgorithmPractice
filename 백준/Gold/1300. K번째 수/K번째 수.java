import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		long low = 1;
		long high = K;
		
		while(low < high) {
			long mid = (low+high) / 2;
			long cnt = 0;
			
			for(int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			
			if(K <= cnt) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		bw.write(String.valueOf(low));
		bw.close();
	}
}
