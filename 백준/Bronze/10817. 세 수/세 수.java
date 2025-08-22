import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int arr[] = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        
		for(int i=0; i<arr.length-1;i++) {
			for(int j =i+1; j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}	
			}
		}
        
		System.out.println(arr[1]);
        sc.close();
	}
}