import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int [] A, tmp;
	static int cnt, K, ans;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 K = Integer.parseInt(st.nextToken());
		 
		 A = new int[N];
		 tmp = new int[N+1];
		 cnt = 0;
		 ans = -1;
		 
		 st = new StringTokenizer(br.readLine());
		 for(int i = 0; i < N; i++) {
			 A[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 merge_sort(0, N-1);
		 
		 bw.write(String.valueOf(ans));
		 br.close();
		 bw.close();
	}
	
	static void merge_sort(int st, int ed) {
		if(st < ed) {
			int q = (st + ed) / 2;
			merge_sort(st, q);
			merge_sort(q+1, ed);
			merge(st, q, ed);
		}
	}
	
	static void merge (int st, int q, int ed) {
		int i = st;
		int j = q + 1;
		int t = 1;
		
		while(i <= q && j <= ed) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
			
			cnt++;
			
			if(cnt == K)
				ans = tmp[t-1];
		}
		
		while(i <= q) {
			tmp[t++] = A[i++];
			
			cnt++;
			
			if(cnt == K)
				ans = tmp[t-1];
		}
			
		
		while(j <= ed) {
			tmp[t++] = A[j++];
			
			cnt++;
			
			if(cnt == K)
				ans = tmp[t-1];
		}
		
		i = st;
		t = 1;
		
		while(i <= ed) {
			A[i++] = tmp[t++];
		}
	}
}