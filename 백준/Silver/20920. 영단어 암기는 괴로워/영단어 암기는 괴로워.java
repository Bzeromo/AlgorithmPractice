import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Map <String, Integer> map = new HashMap<>();
		
		List <String> list = new ArrayList<String>();
		String s;
		
 		for(int i = 0; i < N; i++) {
			s = br.readLine();
			if(s.length() < M) continue;
			
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
 		
 		for(String str : map.keySet()) {
			list.add(str);
		}
 		
 		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(map.get(o1) > map.get(o2))
					return -1;
				else if(map.get(o1) < map.get(o2))
					return 1;
				else if(o1.length() < o2.length())
					return 1;
				else if(o1.length() > o2.length())
					return -1;
				return o1.compareTo(o2);
			}
 		});
 		
 		for(String str : list) {
 			sb.append(str).append("\n");
 		}
 		
 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}