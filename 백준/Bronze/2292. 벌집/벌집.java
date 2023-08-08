import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
 
		int N =1, K=1, count = 1;
 
		while (true) {
			if(N > X-1) {
				break;
			}
			N += (6 * (K++));
			count++;
		}
		
		System.out.println(count);
	}
}