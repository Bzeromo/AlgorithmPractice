import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] triNum = new int[45];
        for(int i = 1; i < 45; i++) {
            triNum[i] = i * (i + 1) / 2;
        }
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int result =  eureka(n, triNum);
            System.out.println(result);
        }
    }

    public static int eureka(int N, int[] triNum) {
        for(int j = 1; j < 45; j++) {
            for (int k = 1; k < 45; k++) {
                for (int z = 1; z < 45; z++) {
                    int sum = triNum[j] + triNum[k] + triNum[z];
                    if (sum == N) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}