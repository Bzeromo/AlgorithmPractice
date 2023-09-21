import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {    
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> arr;
    static int visited[];
    static int N, M, R, cnt = 1;
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new ArrayList<ArrayList<Integer>>();
        visited = new int [N+1];
        
        for(int i = 0; i <= N; i++) {
            arr.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        
        for (int i = 1; i <= N; i++) {
			Collections.sort(arr.get(i), new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
		}
        
        dfs(R);
        
        for(int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    
    static void dfs(int R) {
        visited[R] = cnt;
        
        for (int i = 0; i < arr.get(R).size(); i++) {
			int newNode = arr.get(R).get(i);
			if (visited[newNode] == 0) {
				cnt++;
				dfs(newNode);
			}
		}
    }
    
}

