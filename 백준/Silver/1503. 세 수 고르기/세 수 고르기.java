import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[1002];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i; j <= 1000; j++) {
                for (int k = j; k <= 1001; k++) {
                    if (arr[k] == 1 || arr[j] == 1 || arr[i] == 1) {
                        continue;
                    }

                    answer = Math.min(answer, Math.abs(n - i * j * k));
                }
            }
        }

        System.out.println(answer);
    }
}