import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		
		for(int i = 1; i <= n; i++) {
			int sum = i;
			sum += (i%10) + (i/10%10) + (i/100%10) + (i/1000%10) + (i/10000%10) + (i/100000%10);
			if(sum == n && min > sum) {
				min = sum;
				answer = i;
			}
		}
		
		if(answer == n) {
			answer = 0;
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}
}
