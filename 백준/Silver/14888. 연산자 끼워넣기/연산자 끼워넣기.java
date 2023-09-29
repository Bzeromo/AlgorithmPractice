import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int num[], sel[];
	static boolean visited[];
	static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        sel = new int[N-1];
        visited = new boolean[N-1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int gob = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < plus; i++) {
        	list.add(1);
        }
        
        for(int i = 0; i < minus; i++) {
        	list.add(2);
        }
        
        for(int i = 0; i < gob; i++) {
        	list.add(3);
        }
        
        for(int i = 0; i < div; i++) {
        	list.add(4);
        }
        
        perm(0);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    
    public static void perm(int idx) {
		// 기저파트
		if(idx == N-1) {
			int cnt = 1;
			int sum = num[0];
			for(int i = 0; i < N-1; i++) {
				
				switch(sel[i]) {
				case 1: sum += num[cnt++];
				break;
				case 2: sum -= num[cnt++];
				break;
				case 3: sum *= num[cnt++];
				break;
				case 4: sum /= num[cnt++];
				break;
				}				
			}
			
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		// 사용할 수 있는 모든 원소 체크
		for(int i = 0; i < N-1; i++) {
			if(visited[i]) continue; // 이미 사용한 원소일 때 생략
			
			sel[idx] = list.get(i); // 해당 i번째의 원소를 저장
			visited[i] = true;	   // i번째 원소 사용했다고 표시
			perm(idx+1);
			visited[i] = false;	   // i번째 원상복구
		}
	}
}