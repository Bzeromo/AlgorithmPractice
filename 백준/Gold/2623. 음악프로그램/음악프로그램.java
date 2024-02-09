import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }
 
        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
 
            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(st.nextToken());
                a.get(before).add(singer);
                indegree[singer]++;
 
                before = singer;
            }
        }
 
        String ans = topologicalSort(a, indegree, N);
 
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }
 
    // 위상 정렬
    public static String topologicalSort(ArrayList<ArrayList<Integer>> a, int[] indegree, int N) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
 
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
 
        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
 
            for (int next : a.get(now)) {
                indegree[next]--;
 
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        if (result.size() != N) {
            return "0\n";
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + "\n");
        }
 
        return sb.toString();
 
    }
}
