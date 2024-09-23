import java.util.*;
 
public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [][] arr = new String [n][3];

        double sum = 0;
        double haksum = 0;
        for(int i = 0; i < n; i++) {
            double temp = 0;
            for(int j = 0; j < 3; j++) {
                arr[i][j] = sc.next();
            }	
            String score = arr[i][2];				
            if (score.charAt(0) == 'A') temp = 4; 
            else if (score.charAt(0) == 'B') temp = 3; 
            else if (score.charAt(0) == 'C') temp = 2; 
            else if (score.charAt(0) == 'D') temp = 1;
            
            if (score.length() > 1) { 
                if (score.charAt(1) == '+') temp += 0.3; 
                else if (score.charAt(1) == '-') temp -= 0.3;
            }

            sum += Integer.parseInt(arr[i][1]) * temp;	
            haksum += Integer.parseInt(arr[i][1]);
        }

        System.out.println(String.format("%.2f", sum/haksum));
    }
}