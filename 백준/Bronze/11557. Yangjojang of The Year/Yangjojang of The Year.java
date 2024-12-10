import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<String> university = new ArrayList<>();

        for(int i = 0; i < T; i++) { 
            int N = Integer.parseInt(br.readLine());
            int maxAmount = Integer.MIN_VALUE;
            for(int j = 0; j < N; j++) { 
                String[] input = br.readLine().split(" ");
                String univName = input[0]; 
                int alcohol = Integer.parseInt(input[1]);

                if(maxAmount < alcohol) {
                    maxAmount = alcohol;
                    university.add(univName);
                }
            }
            System.out.println(university.get(university.size() - 1));
        }
        br.close();
    }
}
