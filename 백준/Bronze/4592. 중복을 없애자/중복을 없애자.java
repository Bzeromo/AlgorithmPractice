import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            
            if (n == 0) break;
            
            int defaultNum = sc.nextInt();
            System.out.print(defaultNum + " ");
            
            for (int i = 0; i < n - 1; i++) {
                int nextNum = sc.nextInt();
                if (defaultNum != nextNum) {
                    System.out.print(nextNum + " ");
                    defaultNum = nextNum;
                }
            }
            System.out.println("$");
        }
 
    }
}