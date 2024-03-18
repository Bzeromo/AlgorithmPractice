import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i = 0; i < 5; i++) {
            if(day == Integer.parseInt(st.nextToken())) {
                result++;
            }
        }
        System.out.println(result);
    }
 
}