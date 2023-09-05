import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
        	String [] arr = br.readLine().split("");
        	cnt = 0;
        	int ans = isPalindrome(arr);
        	
        	sb.append(ans).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    
    static int recursion(String[]s, int l, int r) {
    	cnt++;
    	if(l >= r) return 1;
    	else if(!s[l].equals(s[r])) return 0;
    	else return recursion(s, l+1, r-1);
    }
    
    static int isPalindrome(String[]s) {
    	return recursion(s, 0, s.length-1);
    }
}
        