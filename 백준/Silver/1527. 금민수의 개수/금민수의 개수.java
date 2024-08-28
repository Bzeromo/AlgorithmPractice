import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long x, y, answer;

    public static void solve(long number) {
        if (number > y)
            return;
        if (number >= x)
            answer += 1;

        solve(number * 10 + 4);
        solve(number * 10 + 7);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        solve(4);
        solve(7);
        System.out.println(answer);
    }
}