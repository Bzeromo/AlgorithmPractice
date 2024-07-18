import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static String[] words;
    static boolean[] arr = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        
        arr['a' - 'a'] = true;
        arr['n' - 'a'] = true;
        arr['t' - 'a'] = true;
        arr['i' - 'a'] = true;
        arr['c' - 'a'] = true;

        if (k < 5) {
            bw.write(String.valueOf(max));
        } else {
            dfs(0, 0);
            bw.write(String.valueOf(max));
        }
        bw.close();
        br.close();
    }
    
    public static void countWord() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char[] alphas = words[i].toCharArray();
            boolean flag = true;
            for (char c: alphas) {
                if (!arr[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
    
    public static void dfs(int idx, int cnt) {
        if (cnt + 5 == k) {
            countWord();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (arr[i]) {
                continue;
            }

            arr[i] = true;
            dfs(i + 1, cnt + 1);
            arr[i] = false;
        }
    }
}
