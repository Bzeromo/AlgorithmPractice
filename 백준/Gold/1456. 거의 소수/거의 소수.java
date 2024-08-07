import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        
        boolean[] isPrime = new boolean[(int) Math.sqrt(end) + 1];
        for (int i = 2; i < isPrime.length; i++) isPrime[i] = true;
		
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }
        
        int answer = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                long temp = i;
                while (temp <= (double) end / i) {
                    if (temp >= (double) start / i) {
                        answer++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}