import java.util.*;
import java.io.*;
 
class Main {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int tc = stoi(br.readLine());
 
        for(int t=0; t<tc; t++) {
            n = stoi(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;
 
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<n+1; i++) 
                arr[i] = stoi(st.nextToken());
 
            for(int i=1; i<n+1; i++)
                dfs(i);
 
            System.out.println(n - count);
        }
    }
 
    static void dfs(int now) { 
        if(visited[now])
            return;
 
        visited[now] = true;
        int next = arr[now];
 
        if(visited[next] != true)
            dfs(next);
        else {
            if(finished[next] != true) {
                count++;
                for(int i=next; i != now; i = arr[i])
                    count++;
            }
        }
        finished[now] = true;
    }
}