import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int cnt = 0;
        int[] countStr1 = new int[26];
        int[] countStr2 = new int[26];
        
        for(int i=0; i<str1.length(); i++){
            countStr1[str1.charAt(i)-'a']++;
        }
       
        for(int i=0; i<str2.length(); i++){
            countStr2[str2.charAt(i)-'a']++;
        }
        
        for(int i=0; i<26 ; i++){
            int compare = countStr1[i] - countStr2[i];
            
            if(compare !=0)
                cnt += Math.abs(compare);
        }
        
        System.out.println(cnt);
        br.close();
    }
}