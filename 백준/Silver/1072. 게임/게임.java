import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = (int) ((long) Y * 100 / X);
        
        int answer = -1;
        int left = 0;
        int right = (int)1e9;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int newRate = (int) ((long) (Y + mid) * 100 / (X + mid));
            if (newRate != Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
        br.close();
    }
}