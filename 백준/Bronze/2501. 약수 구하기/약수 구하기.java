import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int limit = sc.nextInt();
		int count = 0;
		
		for(int i =1; i < X+1; i++) {
			if(X%i==0) {
				count++;
			}
			
			if(limit == count) {
				System.out.println(i);
				break;
			}
		}
		
		if(limit > count) {
			System.out.println(0);
		}
	}
}