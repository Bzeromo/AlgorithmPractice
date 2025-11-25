import java.io.*;
import java.util.*;
 
 
public class Main {
	public static int N, M;
	public static int[] arr;
	public static int answer = 0;
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	twoPointer();
    	
    	System.out.println(answer);
        br.close();
    }
    
    public static void twoPointer() {
    	int start = 0;
    	int end = 0;
    	int intervalSum = 0;
    	
    	while(start < N) {
    		end = start + 1;
    		while(end < N) {
    			intervalSum = arr[start];
    			intervalSum += arr[end];
    			end += 1;
    			if(intervalSum == M) {
    				answer += 1; 
    				break;
    			}
    		}
    		start += 1;
    		
    	}
    }
    
}