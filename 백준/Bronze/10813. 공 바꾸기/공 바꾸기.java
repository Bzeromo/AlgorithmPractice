import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int [] bar = new int[N];
		
		for(int i =0; i < bar.length; i++) {
			bar[i] = i+1;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			int first = Integer.parseInt(st2.nextToken());
			int last = Integer.parseInt(st2.nextToken());
			int change = bar[first-1];
			
			bar[first-1] = bar[last-1];
			bar[last-1] = change;
		}
		
		for(int i = 0; i < bar.length; i++) {
			bw.write(String.valueOf(bar[i]) + " ");
		}
		
		bw.flush();
		bw.close();
	}

}
