import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Integer.parseInt(br.readLine());
		long result = 1;

		for (int i = 1; i <= n; i++) {
			result *= i;
			result %= 10000000;
			while (result % 10 == 0)
				result /= 10;
		}
        
		System.out.print(result % 10);
        br.close();
	}
}