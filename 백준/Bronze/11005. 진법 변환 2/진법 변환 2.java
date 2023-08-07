import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack <String> stack = new Stack<>();
		int num = sc.nextInt();
		int ari = sc.nextInt();
		int a;
		String sum = "";
	
		while(num!=0) {
			a = num % ari;
			num /= ari;
			
			if(a > 9) a = a+55;
			else a = a+48;
			
			stack.add(String.valueOf((char)a));
		}
		
		while(!(stack.isEmpty()))
			System.out.print(stack.pop());
	}
}

