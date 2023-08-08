import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
 
		int cross = 1, sum = 0;
 
		while (true) {
			if (X <= sum + cross) {	
				
				if (cross % 2 == 1) {
					System.out.print((cross - (X - sum - 1)) + "/" + (X - sum));
					break;
				} 
				else {	
					System.out.print((X - sum) + "/" + (cross - (X - sum - 1)));
					break;
				}
			} else {
				sum += cross;
				cross++;
			}
		}
	}
}