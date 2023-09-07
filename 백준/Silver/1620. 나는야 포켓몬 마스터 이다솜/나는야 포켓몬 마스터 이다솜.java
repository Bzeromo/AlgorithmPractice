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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String s;

		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			s = br.readLine();
			map.put(i, s);
			map2.put(s.toLowerCase(), i);
		}
		
		
		for (int i = 0; i < M; i++) {
           s = br.readLine();
           if(s.charAt(0) < 65) {
        	   sb.append(map.get(Integer.parseInt(s))).append("\n");
           } else { 
        	   sb.append(map2.get(s.toLowerCase())).append("\n");
           } 
        }
		
 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}