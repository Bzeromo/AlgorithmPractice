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
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			if(s.equals("Algorithm")) 
				sb.append(204).append("\n");
			else if(s.equals("DataAnalysis"))
				sb.append(207).append("\n");
			else if(s.equals("ArtificialIntelligence"))
				sb.append(302).append("\n");
			else if(s.equals("CyberSecurity"))
				sb.append("B101").append("\n");
			else if(s.equals("Network"))
				sb.append(303).append("\n");
			else if(s.equals("Startup"))
				sb.append(501).append("\n");
			else 
				sb.append(105).append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	
}
