import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) {
                sb.append(c);
                continue;
            }
            int n = (int)c + 13;
            
            if (Character.isUpperCase(c) && n > 90) {
                n -= 26;
            }
            
            if (Character.isLowerCase(c) && n > 122) {
                n -= 26;
            }
            sb.append((char)n);
        }
        System.out.println(sb);
        br.close();
    }
}