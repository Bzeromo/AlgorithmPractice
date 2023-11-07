import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Number {
	long num, cnt;
	
	Number (long num, long cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	static int [][] ice;
	static int N, M;
	static long ans = -1;
	static Queue<Number> q;
	//동서남북
	static int dr [] = {0, 0, 1, -1};
	static int dc [] = {1, -1, 0, 0};
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		q.add(new Number(N, 0));
		
		while(!q.isEmpty()) {
			Number n = q.poll();
			
			long num = n.num;
			long cnt = n.cnt;
			
			if(num > M) continue;
			
			if(num == M) {
				ans = cnt + 1;
				break;
			}
			
			q.add(new Number(num * 2, cnt+1));
			q.add(new Number(num * 10 + 1, cnt+1));
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
}