import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        solution(N - 1);

        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }

    static int solution(int N) {
        if(dp[N] == null) {
            dp[N] = Math.max(solution(N - 1) + arr[N], arr[N]);

            max = Math.max(dp[N], max);
        }

        return dp[N];
    }
}