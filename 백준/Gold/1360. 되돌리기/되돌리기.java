import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static class TYPE {
		String name;
		char alpa;
		int curTime;
		int backTime;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		TYPE type[] = new TYPE[N];
		boolean check[] = new boolean[N];

		// INPUT
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			type[i] = new TYPE();
			if (st.nextToken().equals("type")) {
				type[i].name = "type";
				type[i].alpa = st.nextToken().charAt(0);
				type[i].curTime = Integer.parseInt(st.nextToken());
			} else {
				type[i].name = "undo";
				type[i].backTime = Integer.parseInt(st.nextToken());
				type[i].curTime = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			if (check[i])
				continue;

			if (!type[i].name.equals("undo")) {
				continue;
			}

			check[i] = true;

			int look = type[i].curTime - type[i].backTime;

			for (int j = i - 1; j >= 0; j--) {
				if (look > type[j].curTime)
					break;
				check[j] = true;
			}
		}
        
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (check[i])
				continue;
			sb.append(type[i].alpa);
		}
		bw.write(sb.toString());
        bw.close();
        br.close();
	}
}
