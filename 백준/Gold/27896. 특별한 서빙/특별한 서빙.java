import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {    
	static int N, M, n, cnt = 0, fire = 0;
	static PriorityQueue<Integer> student;
	static int min = 100000;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		student = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			
			student.add(n);
			fire += n;
			
			if(fire >= M) {
				fire -= student.poll()*2;
				cnt++;
			}
		}
		
		
		
		bw.write(String.valueOf(cnt));
		br.close();
		bw.close();
    }
    


}