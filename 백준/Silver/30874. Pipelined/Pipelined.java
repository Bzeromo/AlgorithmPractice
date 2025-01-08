import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int ans = n-1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(num, max);
        }
        ans += max;

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }

}