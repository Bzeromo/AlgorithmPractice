import java.util.Scanner;

public class Main {
	public static int solve(int N, int C, int[] arr) {
		int count = 0;
		
		for(int i=1; i<=C; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i%arr[j] == 0) {
					count ++;
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		int count = solve(N, C, arr);
		System.out.println(count);
		sc.close();
	}

}