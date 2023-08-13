import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr [] = new int[N];
		
		for(int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N-1; j++) {
				if(arr[j] > arr[j+1]) {
					int idx = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = idx;
				}
			}
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}