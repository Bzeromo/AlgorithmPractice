import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	static Map<Character, Integer> priority = new HashMap<>();
	
	static {
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
	}
	
	public static boolean prior (char n, char m) {
		return priority.get(n) > priority.get(m);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String str = br.readLine();
		Stack <Character> ch = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			char n = str.charAt(i);
			char a;
			if(n == '+' || n == '*' || n == '-' || n == '/') {
				if(ch.isEmpty())
					ch.add(n);
				else {
					if(!prior(n, ch.peek())) {
						while(!ch.isEmpty() && !prior(n, ch.peek())) {
							sb.append(ch.pop());
						}
						ch.add(n);
					} else {
						ch.add(n);
					}
				}
			} else if (n == ')'){
				while(!ch.isEmpty() && (a = ch.pop()) != '(') {
					sb.append(a);
				}
			} else if (n== '('){
				ch.add(n);
			} else {
				sb.append(n);
			}
		}
			
		if(!ch.isEmpty()) {
			int n = ch.size();
			for(int i = 0; i < n; i++) {
				sb.append(ch.pop());
			}
		}
			
		bw.write(sb.toString());
		
		bw.close();
	} // main
} // class
