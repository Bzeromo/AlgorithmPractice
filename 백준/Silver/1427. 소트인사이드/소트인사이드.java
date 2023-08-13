import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String arr [] = sc.nextLine().split("");
		int numArr [] = new int [arr.length];
		
		for(int i =0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(arr[i]);
		}
		
		for(int i =0; i< numArr.length; i++) {
			int max = 0;
			int idx = 0;
			
			for(int j = i; j < numArr.length; j++) {
				if(numArr[j] >= max) {
					max = numArr[j];
					idx = j;
				}
			}
			
			numArr[idx] = numArr[i];
			numArr[i] = max;
		}
		
		for(int i = 0 ; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
	}

}
