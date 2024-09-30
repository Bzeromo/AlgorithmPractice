import java.io.*;
import java.util.*;

public class Main {
	static int answer;
	static int N;
	static int[] numbers;
	static String[] strs;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[2];
		strs = new String[N];
		for(int i=0;i<N;i++) {
			strs[i] = mapping(br.readLine());
		}
		
		answer = 0;
		combine(0,0);
		System.out.println(answer);
	}
	
	
	public static void combine(int start, int cnt) {
		if(cnt == 2) {
			
			if(strs[numbers[0]].equals(strs[numbers[1]])) {
				answer++;
			}
			return;
		}
		
		for(int i=start; i<N;i++) {
			numbers[cnt] = i;
			combine(i+1,cnt+1);
		}
	}
	
	public static String mapping(String str) {
		String answer = "";
		
		Map<Character,Character> map = new HashMap<>();
		char c='a';
		for(int i=0;i<str.length();i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), (char)(c++));
			}
			answer+=map.get(str.charAt(i));
		}
		return answer;
	}

}