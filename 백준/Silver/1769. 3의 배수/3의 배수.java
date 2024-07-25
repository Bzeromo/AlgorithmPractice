import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int cnt =0;

        while(true){
            if(str.length()==1) 
                break;

            long sum=0;
            for(int i=0;i< str.length();i++){
                sum+=Long.parseLong(String.valueOf(str.charAt(i)));
            }
            cnt++;
            str = String.valueOf(sum);
        }
        
        bw.write(String.valueOf(cnt) + "\n");
        
        if(Long.parseLong((str))%3==0){
            bw.write("YES" + "\n");
        }else{
            bw.write("NO" + "\n");
        }
        
        bw.close();
        br.close();
    }
}