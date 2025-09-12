import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int a = 300;
        int b = 60;
        int c = 10;

        int min = Integer.MAX_VALUE;
        int clickA = 0, clickB = 0, clickC = 0, sum = 0;

        for (int i = 0; i <= t/a; i++) {
            for (int j = 0; j <= t/b; j++) {
                for (int k = 0; k <= t/c; k++) {
                    if (a*i + b*j + c*k == t) {
                        sum = i + j + k;
                        if (min > sum) {
                            min = sum;
                            clickA = i;
                            clickB = j;
                            clickC = k;
                        } else {
                            sum = 0;
                        }
                    }
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(clickA + " " + clickB + " " + clickC);
        }
        
        br.close();
    }
}