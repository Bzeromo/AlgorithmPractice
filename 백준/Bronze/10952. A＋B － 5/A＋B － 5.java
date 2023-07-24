import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A,B;
		
		while(true)
		{
			A = sc.nextInt();
			B = sc.nextInt();
			
			if(A+B!=0) {
				System.out.println(A+B);
			}
			else
				break;
				
		}
		sc.close();

	}

}