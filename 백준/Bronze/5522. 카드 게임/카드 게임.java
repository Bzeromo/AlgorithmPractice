import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;  //총점
        for (int i = 1; i <= 5; i++) {
            total += Integer.parseInt(br.readLine());  //총점에 점수를 더해준다
        }
        System.out.print(total);
    }
}