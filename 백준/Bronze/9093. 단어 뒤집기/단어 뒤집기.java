import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            
            for(int j = 0; j < size; j++){
            	StringBuilder sb = new StringBuilder(st.nextToken());
                System.out.print(sb.reverse().toString()+" ");
            }
            System.out.println();
        }
        br.close();
    }
}