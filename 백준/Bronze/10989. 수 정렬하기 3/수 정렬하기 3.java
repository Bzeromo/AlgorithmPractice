import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr [] = new int[N];
		int max = 0;
		
		for(int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		int count [] = new int[max+1];
		
		for(int i = 0; i < N; i++) {
			count[arr[i]]++;
		}
		
		for(int i = 1; i <= max; i++) {
			count[i] += count[i-1]; 
		}
		
		int newArr [] = new int [N];
		
		for(int i = N-1; i >= 0; i--) {
			count[arr[i]]--;
			newArr[count[arr[i]]] = arr[i];
		}

		for(int i =0; i < N; i++) {
			bw.write(String.valueOf(newArr[i]) + "\n");
		}
		bw.close();
	}

}