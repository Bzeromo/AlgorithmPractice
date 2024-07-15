import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] science = new int[4];
		for (int i = 0; i < science.length; i++) {
			science[i] = sc.nextInt();
		}
		int E = sc.nextInt();
		int F = sc.nextInt();
		sc.close();

		Arrays.sort(science);
        
		int sumA = 0;
		for (int i = science.length - 1; i > 0; i--) {
			sumA += science[i];
		}
		System.out.println(sumA + Math.max(E, F));

	}
}