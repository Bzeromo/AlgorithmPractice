import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
 
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') {
                stack.pop();
 
                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result++; 
                }
            }
        }
 
        bw.write(result + "\n");
        br.close();
        bw.close();
    }
 
}
