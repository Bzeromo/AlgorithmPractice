import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
	
		String strArr [] = new String[N];
		int numArr [] = new int[N];
		int n, max = Integer.MIN_VALUE;
		
 		for(int i = 0; i < N; i++) {
 			st = new StringTokenizer(br.readLine());
 			n = Integer.parseInt(st.nextToken());
 			max = Math.max(max, n);
 			
 			numArr[i] = n;
			strArr[i] = st.nextToken();
		}
 		
 		int count [] = new int[max+1];
 		
 		for(int i = 0; i < N; i++) {
 			count[numArr[i]]++;
 		}
 		
 		for(int i = 1; i < count.length; i++) {
 			count[i] += count[i-1];
 		}
 		
 		int sortedArr [] = new int[N];
 		String sortedStrArr [] = new String[N];
 		
 		for(int i = N-1; i >= 0; i--) {
 			sortedArr[--count[numArr[i]]] = numArr[i];
 			sortedStrArr[count[numArr[i]]] = strArr[i];
 		}
 		
 		for(int i = 0; i < N; i++) {
 			sb.append(sortedArr[i]).append(" ").append(sortedStrArr[i]).append("\n");
 		}
 		
 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}