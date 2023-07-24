import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String longInt = "";
		
		for(int i = 0; i < num/4; i++) {
			longInt += "long ";
		}
		
		System.out.println(longInt + "int");
	}

}