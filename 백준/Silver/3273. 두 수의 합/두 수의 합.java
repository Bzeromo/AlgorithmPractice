import java.io.*;
import java.util.*;
 
public class Main {
    
	public int count(int N, int[] arr, int X) {
		int result = 0;
		int sum = 0;
		int lt = 0;
		int rt = N-1;
		
		Arrays.sort(arr);
		
		while(lt < rt) {
			sum = arr[rt] + arr[lt];
			
			if(sum == X) result++;
			
			if(sum < X) {
				lt++;
			}else {
				rt--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Main num = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		int X = Integer.valueOf(br.readLine());
		
		System.out.println(num.count(N, arr, X));
        br.close();
	}
}