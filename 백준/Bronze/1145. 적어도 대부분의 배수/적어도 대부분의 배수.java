import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력값들을 저장해줄 배열 선언
		int[] arr = new int[5];
		//몇개의 입력값이 나누어 떨어지는지 체크할 변수
		int count = 0;
		//결과값을 저장할 변수
		int N = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//몇에서 3개이상이 나눠질지 모르기 때문에 무한루프
		while(true) {
			N++;
			//N값을 나눴을때 입력값들이 나누어 떨어지면 count +1
			for(int i = 0; i < 5; i++) {
				if(N >= arr[i] && N % arr[i] == 0) count++;
			}
			//3개이상 나눠지면 무한루프 종료
			if(count > 2) break;
			//3개이상 나눠지지 않았으면 count 초기화
			count = 0;
		}
		System.out.println(N);
	}

}