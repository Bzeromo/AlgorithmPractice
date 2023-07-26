import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken()), tried = Integer.parseInt(st.nextToken());
		int [] bar = new int[num];

		for(int i = 0; i < tried; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			int first = Integer.parseInt(st2.nextToken());
			int last = Integer.parseInt(st2.nextToken());
			int ball = Integer.parseInt(st2.nextToken());
			
			for(int j = first-1; j < last; j++) {
				bar[j] = ball;
			}
		}
		
		for(int i = 0; i < bar.length; i++) {
			bw.write(String.valueOf(bar[i]) + " ");
		}
		
		bw.flush();
		bw.close();
	}

}
