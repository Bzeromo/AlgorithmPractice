import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {    
	static int M;	
	static int visited[];
	static int min = 100000;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		
		bw.write(String.valueOf(chase(N) - 1));
		br.close();
		bw.close();
    }
    
    static int chase(int n) {
    	Queue <Integer> q = new LinkedList<>();
    	
    	visited[n] = 1;
    	int num;
    	q.add(n);
    	
    	while(!q.isEmpty()) {
    		num = q.poll();
       		
    		if(num == M)
    			return visited[num];
    		
    		if(num-1 >= 0 && visited[num-1] == 0) {
    			visited[num-1] = visited[num] + 1;
    			q.add(num-1);
    		}
    		
    		if(num+1 <= 100000 && visited[num+1] == 0) {
    			visited[num+1] = visited[num] + 1;
    			q.add(num+1);
    		}
    		
    		if(num*2 <= 100000 && num*2 > 0 && visited[num*2] == 0) {
    			visited[num*2] = visited[num] + 1;
    			q.add(num*2);
    		}
    			
    	}
    	return -1;
    }

}