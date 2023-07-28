import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = bf.readLine();
		List <String> strArr = new ArrayList<>();
		
		for(int i =1; i < str.length()+1; i++) {
			strArr.add(String.valueOf(str.charAt(str.length()-i)));
		}
		
		String reverse ="";
		
		for(int i =0; i < str.length(); i++) {
			reverse += strArr.get(i);
		}
		
		if(reverse.equals(str))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
