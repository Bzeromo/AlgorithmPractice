import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [][] arr = new String[5][15];
		
		for(int i =0; i < 5; i++) {
			String [] arr2 = br.readLine().split("");
			for(int j=0; j < arr2.length; j++) {
				arr[i][j] = arr2[j];
			}
		}
		
		String ans ="";
		
		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < 5; i++) {
				if(arr[i][j] == null) 
					continue;
				else 
					ans += arr[i][j];
			}
		}
		
		bw.write(ans);
		bw.close();
	}
}

