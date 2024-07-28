import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i =0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numbers);
        int result = 0;
        
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N-1;    
            
            while(true){
                if(left == i) 
                    left++;
                else if(right == i) 
                    right--;
                if(left >= right) 
                    break;
                
                if(numbers[left] + numbers[right] > numbers[i]) 
                    right--;
                else if(numbers[left] + numbers[right] < numbers[i]) 
                    left++;
                else{      
                    result++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }

}