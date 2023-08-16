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
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		
		if(w-x <= x && min > w-x)
			min = w-x;
		else if(w-x >= x && min > x)
			min = x;
		
		if(h-y <= y && min > h-y)
			min = h-y;
		else if(h-y >= y && min > y)
			min = y;
		
		bw.write(String.valueOf(min));
		bw.close();
	}
}
