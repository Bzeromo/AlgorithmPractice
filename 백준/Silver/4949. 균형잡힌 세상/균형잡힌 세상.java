import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str ="";
		
		while(!str.equals(".")) {
			str = br.readLine();
			String [] st = str.split("");
			
			if(st[0].equals(".")) break;
			
			String answer = "yes";
			Stack<String>stack = new Stack<>();
			Stack<String>stack2 = new Stack<>();
			
			for(int i = 0; i < st.length; i++) {
				stack.push(st[i]);
			}
			
			for(int i = 0; i < st.length; i++) {
				String a = stack.pop();
				if(a.equals(")")) {
					stack2.push(a);
				} else if(a.equals("]")) {
					stack2.push(a);
				} else if(a.equals("(")) {
					if(stack2.isEmpty()) {
						answer = "no";
					} else if(!stack2.pop().equals(")")) {
						answer = "no";
					}
				} else if(a.equals("[")) {
					if(stack2.isEmpty()) {
						answer = "no";
					} else if(!stack2.pop().equals("]")) {
						answer = "no";
					}
				} 
			}
			if(!stack2.isEmpty())
				answer = "no";
			
			bw.write(answer + "\n");
		}
		bw.close();
	} // main
} // class
