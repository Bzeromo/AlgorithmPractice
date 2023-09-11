import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int n;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i <N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			n = Integer.parseInt(st.nextToken());
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1)
				cnt++;
		}
	
		bw.write(String.valueOf(cnt));
		br.close();
		bw.close();
	}
}