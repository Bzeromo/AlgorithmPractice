import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int classRoom [] = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	classRoom[i] = Integer.parseInt(st.nextToken());
        }
        
        long cnt = 0;
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	int student = classRoom[i] - B;
        	cnt++;
        	
        	if(student <= 0)
        		continue;
        	
        	cnt += student / C;
        	
        	if(student % C != 0)
        		cnt++;
        }
        
        bw.write(String.valueOf(cnt));
        br.close();
        bw.close();
    }
}