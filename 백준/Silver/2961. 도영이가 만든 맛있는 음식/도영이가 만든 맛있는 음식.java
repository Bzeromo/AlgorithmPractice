import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, min = Integer.MAX_VALUE;
	static int [][] ingredients;
	
	static class Node {
		int node, p ,q;
		
		public Node(int node, int p, int q) {
			this.node = node;
			this.p = p;
			this.q = q;
		}
	}
	
	public static void solve() throws IOException {
		input();
		calc(0, 1, 0, 0);
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		ingredients = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	static void calc(int idx, int sin, int ssn, int cnt) {
		if (idx == N) {
            if (cnt > 0) {
                min = Math.min(min, Math.abs(sin - ssn));
            }
            return;
        }

        calc(idx + 1, sin * ingredients[idx][0], ssn + ingredients[idx][1], cnt + 1);

        calc(idx + 1, sin, ssn, cnt);
    }
	
	static void output() {
		System.out.println(min);
	}
}