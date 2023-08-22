import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long a = Long.parseLong(br.readLine()) * 4;
		
		StringBuilder sb = new StringBuilder();
		bw.write(sb.append(a).toString());
		
		bw.close();
	} // main
} // class
