import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());			
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gen==1) {
				for(int j = 0; j < arr.length; j++) {
					if((j+1)%num == 0) {
						arr[j] = (arr[j]+1)%2;
					}
				}
			} else {
				int j = 1;
				--num;
				arr[num] = (arr[num]+1)%2;
				while(num+j < arr.length && num-j >= 0) {
					if(arr[num-j] == arr[num+j]) {
						arr[num-j] = (arr[num-j]+1)%2;
						arr[num+j] = (arr[num+j]+1)%2;
					} else {
						break;
					}
					j++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < arr.length; i++) {
			sb.append(String.valueOf(arr[i])).append(" ");
			if((i+1)%20==0) {
				sb.delete(sb.length()-1, sb.length()).append("\n");
			}
		}
		bw.write(sb.delete(sb.length()-1, sb.length()).toString());
		bw.close();
	} // main
} // class
