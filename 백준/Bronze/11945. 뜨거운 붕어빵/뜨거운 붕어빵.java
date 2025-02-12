import java.io.*;
import java.util.*;

public class Main {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		String str1[] = br.readLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
        
		for (int i = 0; i < N; i++)  {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				bw.write(str.charAt(M - j - 1));
			}
			bw.write("\n");
		}
        
		bw.close();
        br.close();
	}
}