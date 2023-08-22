import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0, min = N;
		
		loop: for(int i = M; i <= N; i++) {
			if(i == 1) continue;
			for(int j = 2; j < i; j++) {
				if(i % j == 0 && i != 2) {
					continue loop;
				}
			}
			sum += i;
			min = Math.min(min, i);
		}
		
		StringBuilder sb = new StringBuilder();
		if(sum == 0)
			sb.append(-1);
		else {
			sb.append(sum).append("\n").append(min);
		}
		bw.write(sb.toString());
		bw.close();
	} // main
} // class
