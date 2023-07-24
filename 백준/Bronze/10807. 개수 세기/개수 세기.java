import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int n = Integer.parseInt(bf.readLine());
		int[]arr = new int[n];
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int n2 = Integer.parseInt(bf.readLine());
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] == n2) count++;
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
	}

}