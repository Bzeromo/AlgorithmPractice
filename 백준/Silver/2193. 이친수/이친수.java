import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long [] answer = new long[N+1];

        answer[0] = 0;
        answer[1] = 1;

        for( int i =2; i<=N; i++){
            answer[i] = answer[i-1]+answer[i-2];
        }

        System.out.println(answer[N]);
        br.close();
    }
}