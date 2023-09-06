import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		Map<String, Integer> map = new HashMap<>();

		String a;
 		for(int i = 0; i < N; i++) {
 			a = br.readLine();
			map.put(a, 0);
		}
 		
 		for(int i = 0; i < M; i++) {
 			a = br.readLine();
 			if(map.containsKey(a))
 				map.put(a, map.getOrDefault(a, -1) + 1);
 		}
 		
 		for(String s : map.keySet()) {
 			cnt += map.get(s);
		}

 		bw.write(String.valueOf(cnt));
 		br.close();
 		bw.close();
	}
}