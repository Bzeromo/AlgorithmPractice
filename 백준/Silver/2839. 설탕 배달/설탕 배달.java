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
		int min = -1;
		if(N > 10 && N%3==0) {
			if(N%5%3==0) {
				min = N/5 + N%5/3;
			} else if((N%5+5)%3==0) {
				min = N/5 + (N%5+5)/3 - 1;
			} else if((N%5+10)%3==0) {
				min = N/5 + (N%5+10)/3 - 2;
			} else if((N%5+15)%3==0) {
				min = N/5 + (N%5+15)/3 - 3;
			} else if((N%5+20)%3==0) {
				min = N/5 + (N%5+5)/3 - 4;
			} else {
				min = N/3;
			}
		} else if(N%5==0) {
			min = N/5;
		} else if(N < 10) {
			if(N%3==0) {
				min = N/3;
			} else if((N%5)%3==0) {
				min = N/5 + (N%5+5)/3 - 1;
			}
		} else {
			if(N%5%3==0) {
				min = N/5 + N%5/3;
			} else if((N%5+5)%3==0) {
				min = N/5 + (N%5+5)/3 - 1;
			} else if((N%5+10)%3==0) {
				min = N/5 + (N%5+10)/3 - 2;
			} else if((N%5+15)%3==0) {
				min = N/5 + (N%5+15)/3 - 3;
			} else if((N%5+20)%3==0) {
				min = N/5 + (N%5+5)/3 - 4;
			}
		}
		bw.write(String.valueOf(min));
		bw.close();
	} // main
} // class
