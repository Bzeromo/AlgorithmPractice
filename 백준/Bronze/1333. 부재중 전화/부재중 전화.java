import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> sec = new ArrayList<Boolean>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < l; j++) {    //음악 n초 출력
                sec.add(true);
            }
            
            if(i != n-1) { // 마지막 곡이 아닐 경우
                for(int j = 0; j < 5; j++) {    // 음악과 음악 사이 5초
                    sec.add(false);
                }
            }
        }
        
        int result = 0;
        while(result < sec.size()) {    //벨이 울리는 주기에 따라 해당 sec를 확인하여 음악이 나오지 않는중(false)이면 해당 sec를 출력    
            if(sec.get(result) == false) {
                break;
            }
            result += d;    
        }
        System.out.println(result);
        
        
    }
 
}