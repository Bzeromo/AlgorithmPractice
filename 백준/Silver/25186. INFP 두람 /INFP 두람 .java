import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long person = 0;
		int max = 0;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			person += list.get(i);
			max = Math.max(max, list.get(i));
		}
		
		if (n == 1 && person == 1) {
			sb.append("Happy");
		} else if (person / 2 < max) {
			sb.append("Unhappy");
		} else {
			sb.append("Happy");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}