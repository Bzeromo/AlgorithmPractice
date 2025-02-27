import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        boolean isAP = true;
        int reverseNum = 0;

        var Sequence = new int[N];
        for (int i = 0; i < N; i++) {
            Sequence[i] = Integer.parseInt(br.readLine());
            if (i != 0 && isAP){
                if (i == 1) reverseNum = Sequence[1] - Sequence[0];
                else if (reverseNum != Sequence[i] - Sequence[i - 1]) isAP = false;
            }
        }

        System.out.println((isAP) ? Sequence[N-1] + reverseNum : Sequence[N-1] * (Sequence[1]/Sequence[0]));
        br.close();
    }
}