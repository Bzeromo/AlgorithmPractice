import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int high = 1000;
		int low = 0;
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < L; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == n) {
				count++;
				break;
			}
		
			if(num < n && low < num) low = num;

			if(num > n && high > num) high = num;
		}
		int result = 0;
		if(count == 1) {
			System.out.println(0);
		}else {
			for(int i = (low + 1); i <= n; i++) {
				for(int j = n; j < high; j++) {
					result++;
				}
			}
			System.out.println((result - 1));
		}
        br.close();
	}

}