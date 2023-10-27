import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int min = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr [] = new int[N+1];
		
		for(int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i =0; i < N; i++) {
			arr[i+1] += arr[i];
			min += arr[i];
		}
		
		min += arr[N];
		
		bw.write(String.valueOf(min));
		br.close();
		bw.close();
	}
}
