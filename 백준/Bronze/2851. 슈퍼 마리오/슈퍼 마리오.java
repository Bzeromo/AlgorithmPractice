import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr [] = new int [10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		
		for(int i = 0; i < 10; i++) {
			sum += arr[i];
			
			if(sum >= 100) {
				if(sum - 100 > 100 - (sum-arr[i])) {
					sum -= arr[i];
				}
				break;
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.close();
	}
}
