import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int A,B;
		
		while(sc.hasNextInt())
		{
			A = sc.nextInt();
			B = sc.nextInt();
			
			if(A+B>18)
	            break;
	         else if(A+B<2)
	            break;
			
			System.out.println(A+B);
		}
	}
}