import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> s = new Stack<>();

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while(!s.isEmpty()) {
                if(s.peek()[1] >= top) {
                    sb.append(s.peek()[0]).append(" ");
                    break;
                }
                s.pop();
            }
            if(s.isEmpty()) {
                sb.append(0).append(" ");
            }
            s.push(new int[] {i, top}); 
        }
        
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    
}
