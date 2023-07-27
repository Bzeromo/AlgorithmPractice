import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		
		
		Instant beforeTime = Instant.now();

		int i = n / 2;

		Instant afterTime = Instant.now();
		long diffTime = Duration.between(beforeTime, afterTime).toMillis() / 1000;
		System.out.println(n/n);
		System.out.println(diffTime);

	}
	
	
}
