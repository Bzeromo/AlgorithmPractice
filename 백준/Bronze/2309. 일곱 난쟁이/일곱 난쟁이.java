import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr [] = new int [9];
		int sum = 0;
		for(int i = 0; i< 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		loop: for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i==j) continue;
				else if(sum-arr[i]-arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break loop;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
			
		Arrays.sort(arr);
		
		for(int i = 0; i < 9; i++) {
			if(arr[i]!=0)
				sb.append(arr[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	} // main
} // class
