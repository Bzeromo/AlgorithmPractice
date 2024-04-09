import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 제한을 정하지 않았기 때문에 무한루프
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			//tree는 가짓수. 초기값이 1인 이유는 가지는 무조건 처음에 1개가 있기 때문이다.
			int tree = 1;
			
			//0이 입력되면 반복문 종료
			if(N == 0) {
				break;
			}
			
			for(int i = 0; i < 2 * N; i++) {
				int M = Integer.parseInt(st.nextToken());
				//나란히 뻗어나오는 가지와 가지치기 수가 입력되기 때문에 입력되는 때에 맞는 연산을 진행
				if(i % 2 == 0) {
					tree *= M;
				}else {
					tree -= M;
				}
			}
			System.out.println(tree);
		}
	}

}