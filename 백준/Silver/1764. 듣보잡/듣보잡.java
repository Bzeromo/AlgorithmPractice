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
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<>();
		String s;
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			map.put(s, 1);
		}
		
		for(int i = 0; i < M; i++) {
			s = br.readLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		
		for(String str : map.keySet()) {
			list.add(str);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(String str : list){
			if(map.get(str) == 2) {
				sb.append(str).append("\n");
				cnt++;
			}
		}
		
		bw.write(String.valueOf(cnt) + sb.toString());
		br.close();
		bw.close();
	}
}