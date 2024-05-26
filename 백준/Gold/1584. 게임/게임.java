import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Main {
 
    static public class position implements Comparable<position> { // 우선순위 큐를 사용하기 위해 Comparable하게 class를 생성
        int x;
        int y;
        int c;
 
        public position(int x, int y, int c) {
            this.x = x; // 행 좌표
            this.y = y; // 열 좌표
            this.c = c; // 이미 사용한 생명
        }
 
        @Override
        public int compareTo(position o) { // 생명의 개수에 따른 우선 순위 큐 작성
            if (this.c > o.c)
                return 1;
            else
                return -1;
        }
    }
 
    static int[][] arr = new int[501][501];
    static int[][] visit = new int[501][501];
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int min = Integer.MAX_VALUE;
    static PriorityQueue<position> q = new PriorityQueue<>();
    static int goal = 0;
 
    public static void bfs(position p) {
        for (int i = 0; i < 4; i++) {
            int nx = p.x + d[i][0];
            int ny = p.y + d[i][1];
            int nc = p.c;
 
            if (nx >= 0 && nx < 501 && ny >= 0 && ny < 501 && arr[nx][ny] != 2) { // 범위를 벗어나지 않고, 죽음의 구역이 아닌 경우
                if (visit[nx][ny] != 0 && visit[nx][ny] <= p.c) { // 더 이상 검사할 필요가 없는 경우
                    continue;
                }
 
                if (arr[nx][ny] == 1) { // 위험한 구역인 경우 사용한 생명에 1을 추가
                    nc++;
                }
                if (nx == 500 && ny == 500) { // 목적지 도착
                    min = Math.min(min, nc); // 가장 작은 값 저장
                    goal = 1;
                }
                visit[nx][ny] = p.c;
                q.add(new position(nx, ny, nc));
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int N, M;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fx, fy, sx, sy;
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
 
            for (int j = Math.min(fx, sx); j <= Math.max(fx, sx); j++) {
                for (int k = Math.min(fy, sy); k <= Math.max(fy, sy); k++) {
                    arr[j][k] = 1;
                }
            }
        }
 
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fx, fy, sx, sy;
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
 
            for (int j = Math.min(fx, sx); j <= Math.max(fx, sx); j++) {
                for (int k = Math.min(fy, sy); k <= Math.max(fy, sy); k++) {
                    arr[j][k] = 2;
                }
            }
        }
 
        q.add(new position(0, 0, 1));
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                position p = q.poll();
                if (visit[p.x][p.y] == 0)
                    visit[p.x][p.y] = 1;
               bfs(p); // bfs 수행
            }
        }
 
        if (goal == 1) {
            bw.write(String.valueOf(--min));
        } else {
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
