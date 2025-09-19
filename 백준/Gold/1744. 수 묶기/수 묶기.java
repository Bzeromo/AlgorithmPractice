import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minus = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0)
                minus.add(num);
            else
                plus.add(num);
        }
        int answer = 0;
        
        while(!minus.isEmpty()){
            int cur = minus.poll();
            if(minus.isEmpty()){
                answer += cur;
                break;
            }
            if(minus.peek() == 0)
                minus.poll();
            else
                answer += cur * minus.poll();
        }
        while(!plus.isEmpty()){
            int cur = plus.poll();
            
            if(plus.isEmpty()){
                answer += cur;
                break;
            }
            if(cur == 1)
                answer += 1;
            else if(plus.peek() == 1)
                answer += cur + plus.poll();
            else
                answer += cur * plus.poll();
        }
        bw.write(answer + "");
        bw.close();
        br.close();
    }
}