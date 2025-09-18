import java.io.*;
import java.util.*;

public class Main {
    public static String changeNum(long num, int base) {
        StringBuilder changed = new StringBuilder();
        char[] overTen = {'A', 'B', 'C', 'D', 'E', 'F'};

        if (num == 0) return "0";

        while (num > 0) {
            int mod = (int) (num % base);
            if (mod >= 10) {
                changed.append(overTen[mod - 10]);
            } else {
                changed.append(mod);
            }
            num /= base;
        }
        return changed.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            String converted = changeNum(A, n);
            sb.append(isPalindrome(converted) ? 1 : 0).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
