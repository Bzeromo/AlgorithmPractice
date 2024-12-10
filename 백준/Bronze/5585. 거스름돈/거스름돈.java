import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());  
        int count = 0;  
        int[] money = {500, 100, 50, 10, 5, 1};  
        int i = 0;
        
        while (n != 0) {
            if (n - money[i] >= 0) {
                n -= money[i];
                count++;
            } else {
                i++;
            }
        }
        System.out.print(count);
        br.close();
    }
}