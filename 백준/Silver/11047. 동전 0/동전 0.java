import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K, ans = 0;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int [] won = new int [N];
		
		for(int i = 0; i < N; i++) {
			won[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N-1; i >= 0; i--) {
			ans += (K/won[i]);
			
			K %= won[i];
		}
			
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
    }
    


}