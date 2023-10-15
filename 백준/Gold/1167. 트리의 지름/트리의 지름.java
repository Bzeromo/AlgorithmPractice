import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x, value;
    
    Node() {};
    
    Node(int x, int value) {
        this.x = x;
        this.value = value;
    }
}

public class Main {
    static int N, max = -1;
    static Node basketNode;
    static int node;
    static ArrayList<Node>[] list;
    static ArrayList<Node> basket;
    static boolean [] visited;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }
                
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int n;
            
            while((n = Integer.parseInt(st.nextToken())) != -1) {
                list[v].add(new Node(n, Integer.parseInt(st.nextToken())));
            }
        }
        
        dfsSearch(1, 0);
        
        visited = new boolean[N+1];
        
        dfsSearch(node, 0);
        
        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
    
    static void dfsSearch(int x, int length) {
        if(length > max) {
            node = x;
            max = length;
        }
        visited[x] = true;
        
        for(int i = 0; i < list[x].size(); i++) {
            basketNode = list[x].get(i);
            
            if(visited[basketNode.x]) continue;
            
            dfsSearch(basketNode.x, length + basketNode.value);
            visited[basketNode.x] = true;
        }
    }
}
