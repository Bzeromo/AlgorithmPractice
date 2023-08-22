import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		String answer = "";
		
		if(a+b+c != 180) {
			answer = "Error";
		} else if(a == b && b == c) {
			answer = "Equilateral";
		} else if(a == b || b == c || a == c) {
			answer = "Isosceles";
		} else if(a != b && b != c && a != c) {
			answer = "Scalene";
		}
		
		sb.append(answer);
		
		bw.write(sb.toString());
		
		bw.close();
	} // main
} // class
