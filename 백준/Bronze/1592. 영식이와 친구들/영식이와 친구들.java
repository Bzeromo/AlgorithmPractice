import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int [] arr = new int [N];
		int ball = 0;
		int cnt = 0;
		
		while(arr[ball] != M) {
			arr[ball]++;
			cnt++;
			if(arr[ball] == M) {
				break;
			} else if(arr[ball]%2==1) {
				ball = (ball+L)%N;
			} else {
				ball = (N+ball-L)%N;
			}
		}
		
		bw.write(String.valueOf(cnt-1));
		bw.close();
	} // main
} // class
