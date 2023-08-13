import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr [] = new int[5];
		int sum = 0;
		
		for(int i =0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j =0; j < 4; j++) {
				if(arr[j] < arr[j+1]) {
					int idx = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = idx;
				}
			}
		}
		
		for(int i : arr) {
			sum+=i;
		}
		
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}

}