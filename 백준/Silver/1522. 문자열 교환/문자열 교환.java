import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); 

        int total = 0; 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') total++;
        }

        int aMax = 0; 
        for (int i = 0; i < str.length(); i++) {
            int aCnt = 0; 

                for (int j = 0; j < total; j++) {
                int index = (i + j < str.length() ? i + j : i + j - str.length()); 

                if (str.charAt(index) == 'a') aCnt++;

                if (aCnt > aMax) aMax = aCnt;
            }
        }

        System.out.println(total - aMax);
    }
}