import java.io.*;
import java.util.*;

public class Main {
    static char[][] mat;
    static int[][] dir = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int r = read(), c = read();

        mat = new char[r][c];
        for (int i = 0; i < r; i++) mat[i] = br.readLine().toCharArray();

        r--;
        c--;
        int[] arr = new int[5];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cnt = getCount(i, j);
                if (cnt != -1) arr[cnt]++;
            }
        }

        for (int i : arr) sb.append(i).append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static int getCount(int y, int x) {
        int cnt = 0;
        for (int[] d : dir) {
            char c = mat[y + d[0]][x + d[1]];
            if (c == 'X') cnt++;
            else if (c == '#') return -1;
        }

        return cnt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) 
            n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }
}