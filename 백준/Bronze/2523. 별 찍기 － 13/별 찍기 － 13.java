import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
        br.close();
        
		for (int i = 1; i <= N; i++) {	// 1 ~ N
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
 
		for (int i = N - 1; i > 0; i--) {	// N+1 ~ 2N-1
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}