import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if(num==-1) break;
			
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			sb.append(num + " = ");
			
			for(int i = 1; i < num; i++) {
				if(num % i==0) {
					sb.append(i + " + ");
					sum += i;
				}
			}
			
			if(sum != num)
				System.out.println(num + " is NOT perfect.");
			else
				System.out.println(sb.delete(sb.length()-3, sb.length()-1).toString());
		}
	}
}
