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
			
		while(true) {
			StringBuilder sb2 = new StringBuilder();
			String n = br.readLine();
			if(n.equals("0"))
				break;
			
			if(sb2.append(n).reverse().toString().equals(n))
				sb.append("yes");
			else
				sb.append("no");
			
			sb.append("\n");
		}
		
		
 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}