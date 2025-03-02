import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] agents = new String[5]; 
        
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String fbi = st.nextToken();
			agents[i] = fbi;
		}
		
		ArrayList<Integer> results = new ArrayList<Integer>();
        
		for(int i = 0; i < 5; i++) {
			Pattern pattern = Pattern.compile(".*FBI.*");
			Matcher matcher = pattern.matcher(agents[i]);
            
			if(matcher.find()) {
				results.add(i + 1);
			}
		}
        
		if(results.isEmpty()) {
			System.out.println("HE GOT AWAY!");
		}
		else {
			for(int ele : results) {
				System.out.print(ele + " ");
			}
		}
        
        br.close();
	}
}