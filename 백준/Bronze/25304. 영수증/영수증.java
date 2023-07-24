import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int priceHap = sc.nextInt();
		int buy = sc.nextInt();
		int realPrice = 0;
		
		for(int i = 0; i < buy; i++) {
			realPrice += (sc.nextInt() * sc.nextInt());	
		}
		
		if(realPrice == priceHap)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
