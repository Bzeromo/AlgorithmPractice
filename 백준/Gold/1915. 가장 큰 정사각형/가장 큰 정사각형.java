import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("");

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        int[][] psum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + map[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    int res = 1;

                    int idx = 1;
                    while (i + idx <= N && j + idx <= M) {
                        int space = psum[i + idx][j + idx]
                                - psum[i + idx][j - 1]
                                - psum[i - 1][j + idx]
                                + psum[i - 1][j - 1];

                        int len = idx + 1;
                        if (space != len * len) {
                            break;
                        }

                        res = len * len;
                        idx++;
                    }
                    ans = Math.max(ans, res);
                }
            }
        }

        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
}
