import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num = sc.next().toCharArray();
		
		int ari = sc.nextInt();
		int sum = 0;
		
		for(int i =1; i <= num.length; i++) {
			int a = num[num.length-i];
			if(a >= 65) a = a-55;
			else a = a-48;
			
			sum += a * (int)Math.pow(ari, i-1);
		}
		
		System.out.println(sum);
	}
}

