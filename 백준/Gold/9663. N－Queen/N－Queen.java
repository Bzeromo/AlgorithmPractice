import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Main {
    public static int [] r; // 배열 (겸 행)
    public static boolean [] c; // 열 검증
    public static boolean [] diag1; // 대각선 1 검증
    public static boolean [] diag2; // 대각선 2 검증
    public static int N, cnt; // 원소수, 카운트
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
         
        
        N = Integer.parseInt(br.readLine());
        r = new int[N];
        c = new boolean[N];
        diag1 = new boolean[N*2-1];
        diag2 = new boolean[N*2-1];
        cnt = 0;
         
        queenSet(0);
         
        sb.append(String.valueOf(cnt));
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
     
    public static void queenSet(int idx) {
        // 기저조건
        for(int i = 0; i < N; i++) {
            if(!c[i] && !diag1[idx + i] && !diag2[idx - i + (N-1)]) {
                r[idx] = i;
                if(idx == N-1) {
                    cnt++;
                } else {
                    c[i] = diag1[idx + i] = diag2[idx - i + (N-1)] = true;
                    queenSet(idx+1);
                    c[i] = diag1[idx + i] = diag2[idx - i + (N-1)] = false;
                }
            }
        }
    }
}