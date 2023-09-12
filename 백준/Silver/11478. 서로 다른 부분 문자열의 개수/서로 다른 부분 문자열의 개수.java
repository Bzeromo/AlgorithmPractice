import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int length = str.length();
		String st;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int cut = 1;
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				st = str.substring(j, j+cut);
				map.put(st, map.getOrDefault(st, 0) + 1);
				if(j+cut == str.length())
					break;
			}
			cut++;
		}
		
	
		bw.write(String.valueOf(map.size()));
		br.close();
		bw.close();
	}
}