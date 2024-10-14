import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String str = br.readLine();
        int count = 0;
        char word = str.charAt(0);
 
        for(int i = 1; i < str.length(); i++) {
             if(word != str.charAt(i)) {
                 word = str.charAt(i);
                 count ++;
             }
        }
 
        System.out.println((count / 2) + count % 2);
        br.close();
    }
}