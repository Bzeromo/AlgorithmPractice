import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int v, w;
	
	Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
}

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
		
		Node node = chase(N);
		
		bw.write(String.valueOf(node.w));
		br.close();
		bw.close();
    }
    
    static Node chase(int n) {
    	Queue <Node> q = new LinkedList<>();
    	
    	visited[n] = 1;
    	int num = 0;
    	int cnt = 0;
    	Node node;
    	q.add(new Node(n, cnt));
    	
    	while(!q.isEmpty()) {
    		node = q.poll();
       		num = node.v;
       		cnt = node.w;
    		
    		if(num == M)
    			return new Node(visited[num], cnt);
    		
    		if(num*2 <= 100000 && num*2 > 0 && visited[num*2] == 0) {
    			visited[num*2] = visited[num] + 1;
    			q.add(new Node(num*2, cnt));
    		}
    		
    		if(num-1 >= 0 && visited[num-1] == 0) {
    			visited[num-1] = visited[num] + 1;
    			q.add(new Node(num-1, cnt+1));
    		}
    		
    		if(num+1 <= 100000 && visited[num+1] == 0) {
    			visited[num+1] = visited[num] + 1;
    			q.add(new Node(num+1, cnt+1));
    		}
    			
    	}
    	return null;
    }

}