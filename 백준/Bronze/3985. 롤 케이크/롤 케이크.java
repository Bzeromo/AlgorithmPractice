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
		
		int cake [] = new int [Integer.parseInt(br.readLine())+1];
		int N = Integer.parseInt(br.readLine());
		int greedy = Integer.MIN_VALUE, greedyHuman = 0, piggy = Integer.MIN_VALUE, piggyHuman = 0;
		
		for(int i =1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(k-p > greedy) {
				greedy = k-p;
				greedyHuman = i;
			}
			
			for(int j = p; j <= k; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
				}
			}
		}
		
		int count[] = new int [cake.length+1];
		
		for(int i = 0; i < cake.length; i++) {
			count[cake[i]]++;
		}
		
		for(int i = 1; i < count.length; i++) {
			if(count[i] > piggy) {
				piggy = count[i];
				piggyHuman = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(greedyHuman).append("\n").append(piggyHuman);
		bw.write(sb.toString());
		bw.close();
	}

}
