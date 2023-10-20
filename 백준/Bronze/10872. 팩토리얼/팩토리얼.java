import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(fac(N)));
		br.close();
		bw.close();
	}
	
	static int fac(int n) {
		if(n == 1 || n == 0)
			return 1;
		
		return n * fac(n-1);
	}
}
