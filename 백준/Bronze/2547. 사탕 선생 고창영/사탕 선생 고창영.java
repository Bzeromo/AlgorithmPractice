import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            BigInteger sum = new BigInteger("0");
            
            for (int j = 0; j < n; j++) {
                sum = sum.add(scanner.nextBigInteger());
            }
            
            String reminder = String.valueOf(sum.remainder(BigInteger.valueOf(n)));
            if (reminder.equals("0")) System.out.println("YES");
            else System.out.println("NO");
            
        }
    }
}