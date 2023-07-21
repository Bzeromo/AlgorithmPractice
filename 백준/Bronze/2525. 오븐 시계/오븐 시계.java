import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int hour = 0, minute = 0;

		minute = (b+c) % 60;
		hour = a + (b+c) / 60;
		if(hour > 23) {
			hour = hour - 24;
		}
			
		System.out.println(hour + " " + minute);
	}

}
