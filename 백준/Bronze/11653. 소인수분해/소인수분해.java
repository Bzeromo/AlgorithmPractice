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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) return;
		else if(N==2) sb.append(2);
		else {
			for(int i = 2; i <= N; i++) {
				if(N%i == 0) {
					sb.append(i).append("\n");
					N /= i;
					i--;
					continue;
				}
			}
		}

		bw.write(sb.toString());
		bw.close();
	} // main
} // class
