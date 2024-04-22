import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());
		//주사위 눈의 합의 개수를 저장 할 배열
		int[] arr= new int[(S1 + S2 + S3) - 2];
		
		//개수를 저장하기 위한 반복문
		for(int i = 1; i <= S1; i++) {
			for(int j = 1; j <= S2; j++) {
				for(int k = 1; k <= S3; k++) {
					int sum = i + j + k;
					arr[sum - 3]++;
				}
			}
		}
		
		int max = 0;
		int result = 0;
		
		//최댓값이 갱신 될때마다 max에 인덱스에 저장된 값과 result에 인덱스 값 + 3을 저장.
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				result = i + 3;
			}
		}
		System.out.println(result);
	}

}