import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = bf.readLine();
		List <String> strArr = new ArrayList<>();
		
		for(int i =0; i < str.length(); i++) {
			strArr.add(String.valueOf(str.charAt(i)).toUpperCase());
		}
		
		Collections.sort(strArr);

		int max = 0, count = 1;
		String ans="";
		String s = strArr.get(0);
		
		for(int i =1; i < strArr.size(); i++) {
			if(!(strArr.get(i).equals(s))) {
				if(max < count) {
					max = count;
					ans = s;
				}
				else if(max == count) {
					ans = "?";
				}
				count = 0;
			}
			count++;
			s = strArr.get(i);
		}
		if(max < count) {
			max = count;
			ans = s;
		}
		else if(max == count) {
			ans = "?";
		}
		
		bw.write(ans);
		bw.close();
	}
	
}
