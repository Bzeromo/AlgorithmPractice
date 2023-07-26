import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int i =0; i < T; i++) {
			StringTokenizer str = new StringTokenizer(bf.readLine());
			String str2 = "";
			
			int num = Integer.parseInt(str.nextToken());
			String test = str.nextToken();
			
			for(int j=0; j < test.length(); j++) {
				for(int k=0; k < num; k++) {
					str2 += test.charAt(j);
				}
			}
			
			System.out.println(str2);
		}
		
	}

}
