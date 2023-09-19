import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	static int N;
	static int arr [];
	static Integer memo [];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		memo = new Integer [N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int i = 0; i < N; i++) {
			solution(i);
		}
		
		int max = memo[0];
		
		for(int i = 1; i < N; i++) {
			max = Math.max(max, memo[i]);
		}
		
		bw.write(String.valueOf(max));
		br.close();
		bw.close();
	}
	
	static int solution(int n) {
		if(memo[n] == null) {
			memo[n] = 1;
			
			for(int i = n - 1; i >= 0; i--) {
				if(arr[i] < arr[n])
					memo[n] = Math.max(memo[n], solution(i) + 1);
			}
		}
		
		return memo[n];
	}
	
}

