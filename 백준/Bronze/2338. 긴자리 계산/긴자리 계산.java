
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 스캐너 호출
		BigInteger A = new BigInteger(String.valueOf(sc.next()));
		BigInteger B = new BigInteger(String.valueOf(sc.next()));
		
		System.out.println(A.add(B));
		System.out.println(A.subtract(B));
		System.out.println(A.multiply(B));

	}
}