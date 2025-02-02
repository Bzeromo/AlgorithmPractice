import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sce = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) { 
                return;
            }else {
                sce++;
            }
            
            ArrayList<String> girls = new ArrayList<String>();
            
            for(int i = 0; i < n; i++) {
                girls.add(br.readLine());
            }
            
            ArrayList<Integer> isNum = new ArrayList<Integer>();
            for(int i = 0; i < n*2-1; i++ ) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                
                if (isNum.contains(num)) {
                    isNum.remove((Integer)num);
                }else {
                    isNum.add(num);
                }
            }
            
            int resultgirl = isNum.get(0);
            System.out.println(sce + " " + girls.get(resultgirl-1));  
        }
    }
}