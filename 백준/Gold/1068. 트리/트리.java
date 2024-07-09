import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int del;
    static int parent[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
           graph[i] = new ArrayList<>();     
        }
       
        int root = -1;
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            
            if (p == -1) {
                root = i; 
            } else {
                graph[i].add(p);
                graph[p].add(i);
            }
        }
        
        del = Integer.parseInt(br.readLine());
        
        if (del == root) {
            System.out.println(0);
            return;
        } else {
            dfs(root);
        }
        System.out.println(ans);
    }

    static void dfs(int v) {
        visited[v] = true;
        int nodes = 0;
        for (int cur : graph[v]) {
            if (cur != del && !visited[cur]) {
                nodes++;
                dfs(cur);
            }
        }
        if (nodes == 0) {
            ans++;
        }
    }
}