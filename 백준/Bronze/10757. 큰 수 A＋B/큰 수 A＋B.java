import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. 큰 수 입력받고 합 하기 - 10757번
        Scanner scan = new Scanner(System.in);
        BigInteger big1 = scan.nextBigInteger();
        BigInteger big2 = scan.nextBigInteger();

        System.out.println(big1.add(big2));
    }
}