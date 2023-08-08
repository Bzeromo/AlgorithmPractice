
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N = 2;
		for(int i =0; i<T; i++) {
			N = N + (N-1);
		}
		System.out.println(N*N);
	}
}

