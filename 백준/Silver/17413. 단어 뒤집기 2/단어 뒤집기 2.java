import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		char [] arr = br.readLine().toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '<') {
				if(sb2.length() != 0) {
					sb.append(sb2.reverse().toString());
					sb2.delete(0, sb2.length());
				}
				for(int j = i; j < arr.length; j++) {
					if(arr[j] == '>') {
						sb.append(arr[j]);
						break;
					}
					sb.append(arr[j]);
					i++;
				}
			} else if(arr[i] == ' ') {
				sb.append(sb2.reverse().toString()).append(' ');
				sb2.delete(0, sb2.length());
			} else {
				sb2.append(arr[i]);
			}	
		}
		
		if(sb2.length() != 0) {
			sb.append(sb2.reverse().toString());
		}
		
		
		bw.write(sb.toString());
		bw.close();
	}
}
