import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			bw.write(num1 + num2 + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
