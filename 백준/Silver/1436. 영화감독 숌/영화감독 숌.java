import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int i = 665;
		
		while(N != cnt) {
			i++;
			if(i/100%10 == i/10%10 && i/10%10 == i%10 && i%10 == 6) 
				cnt++;
			else if(i > 1000 && i/1000%10 == i/100%10 && i/100%10 == i/10%10 && i/10%10 == 6)
				cnt++;
			else if(i > 10000 && i/10000%10 == i/1000%10 && i/1000%10 == i/100%10 && i/100%10 == 6)
				cnt++;
			else if(i > 100000 && i/100000%10 == i/10000%10 && i/10000%10 == i/1000%10 && i/1000%10 == 6)
				cnt++;
			else if(i > 1000000 && i/1000000%10 == i/100000%10 && i/100000%10 == i/10000%10 && i/10000%10 == 6)
				cnt++;
			else if(i > 10000000 && i/10000000%10 == i/1000000%10 && i/1000000%10 == i/100000%10 && i/100000%10 == 6)
				cnt++;
		}
		
		bw.write(String.valueOf(i));
		bw.close();
	}
}
