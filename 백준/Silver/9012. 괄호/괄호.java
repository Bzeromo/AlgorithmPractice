import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			String str = sc.next();
			String [] strArr = str.split("");
			Stack<String> stack = new Stack<>();
			Stack<String> stack2 = new Stack<>();
			
			for(int j=0; j < strArr.length; j++) {
				stack2.add(strArr[j]);
			}
			
			for(int j=0; j < strArr.length; j++) {
				stack.add(stack2.pop());
			}
			
			if(stack.size()%2 == 1) {
				System.out.println("NO");
				continue;
			}
				
			while(!stack.isEmpty()) {
				String s = stack.pop();
				if(s.equals("(")) {
					stack2.add(s);
				} else if(s.equals(")")) {
					if(!stack2.isEmpty() && stack2.peek().equals("(")) {
						stack2.pop();
						continue;
					} else {
						break;
					}
				}
			}
			if(stack.isEmpty() && stack2.isEmpty())
				System.out.println("YES");
			else System.out.println("NO");
		}
		
		
	}
}

