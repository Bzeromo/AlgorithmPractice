import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int S;
	static String str;
	static Set<Integer> set[];
	static char[][] lcd;
	static StringBuilder sb;
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		str = st.nextToken();
		
		lcd = new char[2 * S + 3][(S + 2) * str.length() + str.length() - 1];
		set = new HashSet[7];
		
		set[0] = new HashSet<>(Arrays.asList(2, 3, 5, 6, 7, 8, 9, 0));
		set[1] = new HashSet<>(Arrays.asList(4, 5, 6, 8, 9, 0));
		set[2] = new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8, 9, 0));
		set[3] = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 8, 9));
		set[4] = new HashSet<>(Arrays.asList(2, 6, 8, 0));
		set[5] = new HashSet<>(Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9, 0));
		set[6] = new HashSet<>(Arrays.asList(2, 3, 5, 6, 8, 9, 0));
		
		br.close();
	}
	
	static void calc() {
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';

			for (int j = 0; j < set.length; j++) {
				if (set[j].contains(num)) {
					fill(i, j);
				}
			}
		}

		sb = new StringBuilder();
		for (int i = 0; i < lcd.length; i++) {
			for (int j = 0; j < lcd[0].length; j++) {
				char c = lcd[i][j] == '\u0000' ? ' ': lcd[i][j];
				sb.append(c);
			}
			sb.append("\n");
		}
    }
	
	private static void fill(int index, int segment) {
		if (segment == 0)
			for (int i = 0; i < S; i++)
				lcd[0][(S + 2 + 1) * index + 1 + i] = '-';

		if (segment == 3)
			for (int i = 0; i < S; i++)
				lcd[S + 1][(S + 2 + 1) * index + 1 + i] = '-';

		if (segment == 6)
			for (int i = 0; i < S; i++)
				lcd[2 * S + 2][(S + 2 + 1) * index + 1 + i] = '-';

		if (segment == 1)
			for (int i = 0; i < S; i++)
				lcd[i + 1][(S + 2 + 1) * index] = '|';

		if (segment == 4)
			for (int i = 0; i < S; i++)
				lcd[S + 1 + i + 1][(S + 2 + 1) * index] = '|';

		if (segment == 2)
			for (int i = 0; i < S; i++)
				lcd[i + 1][(S + 2 + 1) * index + S + 1] = '|';

		if (segment == 5)
			for (int i = 0; i < S; i++)
				lcd[S + 1 + i + 1][(S + 2 + 1) * index + S + 1] = '|';
	}

	
	static void output() {
		System.out.println(sb);
	}
}