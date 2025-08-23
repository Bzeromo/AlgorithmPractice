import java.io.*;
import java.util.*;

public class Main {
	public static boolean[] prime = new boolean[10001];
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		get_prime();
 
		int T = Integer.parseInt(br.readLine());
 
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int first_partition = n / 2;
			int second_partition = n / 2;
 
			while (true) {
				if (!prime[first_partition] && !prime[second_partition]) {
					System.out.println(first_partition + " " + second_partition);
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
       br.close();
	}
 
	public static void get_prime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}