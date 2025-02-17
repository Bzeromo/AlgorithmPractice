import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int N = A.length();
        int M = B.length();

        int a, b=0;
        
        for(a=0;a<N;a++) {
            if((b = B.indexOf(A.charAt(a)))>=0) break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            if(i==b) {
                sb.append(A).append("\n");
                continue;
            }
            for(int j=0;j<N;j++) {
                if(j==a) sb.append(B.charAt(i));
                else sb.append(".");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}