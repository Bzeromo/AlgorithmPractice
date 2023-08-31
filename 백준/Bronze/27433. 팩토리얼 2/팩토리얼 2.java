import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	 static int N;
	 static long n;
	    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        	        
        if(N == 0) {
        	bw.write(String.valueOf(1));
        }
        else
        	bw.write(String.valueOf(pow(N)));
        br.close();
        bw.close();
    }
    
    static long pow(int N) {
    	if(N == 1 || N == 0)
    		return 1;
    	
    	n = N * pow(N-1);

    	return n;
    }
} // class
