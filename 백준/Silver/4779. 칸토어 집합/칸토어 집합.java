import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		
		while((input = br.readLine()) != null && !input.isEmpty()) {
			int n = Integer.parseInt(input); 
			sb.delete(0, sb.length());
			makeStr(n);
			solution(0, (int)Math.pow(3, n));
			sb.append("\n");
			bw.write(sb.toString());
		}
		br.close();
		bw.close();
	}
	
	static void makeStr(int n) {
		for(int i = 0; i < Math.pow(3, n); i++) {
			sb.append("-");
		}
	}
	
	static void solution(int start, int n) {
		if(n == 1)
			return;
		
		int newSize = n / 3;
		
		for(int i = start+newSize; i < start + 2 * newSize; i++) {
			sb.setCharAt(i, ' ');
		}
		
		solution(start, newSize);
		solution(start+2*newSize, newSize);
	}
}

