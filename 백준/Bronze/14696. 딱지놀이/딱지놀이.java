import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- != 0)
        {
            int a, b;
            int[] A = new int[5];
            int[] B = new int[5];
            int count = 0;

            String[] s = br.readLine().split(" ");
            int aN = Integer.parseInt(s[0]);
            for (int i = 1; i <= aN; i++) {
                a = Integer.parseInt(s[i]);
                A[a]++;   
            }
            
            s = br.readLine().split(" ");
            int bN = Integer.parseInt(s[0]);
            for (int i = 1; i <= bN; i++) {
                b = Integer.parseInt(s[i]);
                B[b]++;
            }

            for (int i = 4; i > 0; i--) {
                if (A[i] > B[i]) {
                    System.out.println("A");
                    break;
                }
                else if (A[i] < B[i]) {
                    System.out.println("B");
                    break;
                }
                else count++;  
            }
            
            if (count == 4) System.out.println("D");
        }
        br.close();
    }
}