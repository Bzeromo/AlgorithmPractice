import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		
		int N = Integer.parseInt(br.readLine());
		long numArr [] = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i< N; i++ ) {	
			numArr[i] = Long.parseLong(st.nextToken());
		}
		
		List<Long> arrList = Arrays.stream(numArr).boxed().collect(Collectors.toList());

		Set<Long> arrSet = new HashSet<>(arrList);

		long [] sortedNumArr = arrSet.stream().mapToLong(Long::longValue).toArray(); // [1, 3, 0]
		
		Arrays.sort(sortedNumArr);
		
		for(int i = 0; i < N; i++) {
			sb.append(Arrays.binarySearch(sortedNumArr, numArr[i])).append(" ");
		}
		
 		bw.write(sb.toString());
 		br.close();
 		bw.close();
	}
}