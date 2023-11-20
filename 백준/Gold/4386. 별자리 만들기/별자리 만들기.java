import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int val;
    double x, y;
    
    public Node(int val, double x, double y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int end;
    double cost;
    
    public Edge(int end, double cost) {
        this.end = end;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge e) {
        if(this.cost < e.cost) 
        	return -1;
        return 1;
    }
}

public class Main {
	
    static int N;
    static ArrayList<Node> startList = new ArrayList<>();
    static ArrayList<Edge>[] edgeList; 
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        edgeList = new ArrayList[N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            
            startList.add(new Node(i, x, y));
            edgeList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                double dist = distance(startList.get(i), startList.get(j));
                edgeList[i].add(new Edge(j, dist));
                edgeList[j].add(new Edge(i, dist));
            }
        }
        
        visited = new boolean[startList.size()];
        double result = prim();
        
        System.out.printf("%.2f", result);
    }
    
    static double distance(Node n, Node n2) {
    	return Math.sqrt(Math.pow(n.x - n2.x, 2) + Math.pow(n.y - n2.y, 2));
    }
    
    static double prim() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(0, 0));
        double dist = 0;
        
        while(!q.isEmpty()) {
            Edge curr = q.poll();
            
            if(visited[curr.end] == false) {
                dist += curr.cost;
                visited[curr.end] = true;
            }
            else continue;        
            
            for(int i = 0; i < edgeList[curr.end].size(); i++) {
                Edge next = edgeList[curr.end].get(i);
                if(visited[next.end] == false) q.offer(new Edge(next.end, next.cost));
            }
        }
        return dist;
    }
    
}