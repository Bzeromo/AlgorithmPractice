import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int sum = 0;
		long count =0; 

		for(int i=0; i < n-1; i++) {
			for(int j=i+1; j < n; j++) {
				sum = sum + i * j;
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println(2);
		
	}
}
