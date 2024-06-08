import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String str = br.readLine();
	    StringTokenizer st = new StringTokenizer(str);
	    int x = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    String sx = Integer.toBinaryString(x);
	    String sk = Integer.toBinaryString(k);
	    int klen = sk.length();
	    int xlen = sx.length();
	    int idx = klen-1;
	    long result=0;
	    char c;
	    
	    for(int i=0;idx>=0;i++){
	        if(i<xlen)  c = sx.charAt(xlen-1-i);
	        else c = '0';
	        if(c=='0'){
	            if(sk.charAt(idx)=='1'){
	               long vv = (long)Math.pow(2,i); 
	               result+=vv;
	            }
	            idx--;
	        }
	    }
	    bw.write(String.valueOf(result));
        bw.close();
        br.close();
	}
}