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
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int wt = t - (w-p);
		if(t + p <= w)
			p += t;
		else if((wt / w) % 2 != 0)
			p = wt % w;
		else
			p = w - (wt % w);
		
		int ht = t - (h-q);
		if(t + q <= h)
			q += t;
		else if((ht / h) % 2 !=0)
			q = ht % h;
		else
			q = h - (ht % h);
		
		StringBuilder sb = new StringBuilder();
		sb.append(p).append(" ").append(q);
		bw.write(sb.toString());
		bw.close();
	}

}
