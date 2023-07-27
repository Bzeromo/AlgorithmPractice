import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int sum = 0;
		long count =0; 
		
		long num = (long)n * (long)n * (long)n;
		
		System.out.println((long)num);
		System.out.println(3);
		
	}
}
