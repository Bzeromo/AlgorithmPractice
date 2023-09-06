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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int a;
 		for(int i = 0; i < N; i++) {
 			a = Integer.parseInt(st.nextToken());
			map.put(a, 1);
		}
 		
 		N = Integer.parseInt(br.readLine());
 		st = new StringTokenizer(br.readLine());
 		
 		for(int i = 0; i < N; i++) {
 			a = Integer.parseInt(st.nextToken());
			map.put(a, map.getOrDefault(a, 0));
			sb.append(map.get(a)).append(" ");
 		}

 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}