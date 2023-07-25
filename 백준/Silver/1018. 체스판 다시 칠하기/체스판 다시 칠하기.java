import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
		char [][] chess = new char[n1][n2];

		for(int i = 0; i < n1; i++) {
			String st2 = bf.readLine();
			for(int j = 0; j < n2; j++) {
				chess[i][j] = st2.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int a = 0; a < (n1 - 7); a++) {
			for(int b = 0; b < (n2-7); b++) {
				char ch2 = chess[a][b];
				int count = 0;
				int count2 = 1;
				
				for(int i = 0; i < 8; i++) {
					char ch = chess[i+a][b];
					for(int j = 0; j < 8; j++) {
						if(j==0 && i!=0 && ch == ch2) {
							count++;
							if(ch2 == 'B') {
								ch2 = 'W';
								ch = ch2;
							}
							else  {
								ch2 = 'B';
								ch = ch2;
							}
						}
						else if(j==0 && i!=0 && chess[i+a][b] != ch2) {
							ch2 = chess[i+a][b];
							ch = ch2;
						}
						else if(j!=0 && chess[i+a][j+b]==ch) {
							count++;
							if(ch == 'B') {
								ch = 'W';
							}
							else ch = 'B';
						}
						else {
							ch = chess[i+a][j+b];
						}
					}
				}
				
				char ch = chess[a][b];
				
				if(ch == 'B') ch = 'W';
				else ch = 'B';
				
				ch2 = ch;
				
				for(int i = 0; i < 8; i++) {
					if(i!=0) ch = chess[i+a][b];
					for(int j = 0; j < 8; j++) {
						if(j==0 && i!=0 && ch == ch2) {
							count2++;
							if(ch2 == 'B') {
								ch2 = 'W';
								ch = ch2;
							}
							else  {
								ch2 = 'B';
								ch = ch2;
							}
						}
						else if(j==0 && i!=0 && ch != ch2) {
							ch2 = ch;
						}
						else if(j!=0 && chess[i+a][j+b]==ch) {
							count2++;
							if(ch == 'B') {
								ch = 'W';
							}
							else ch = 'B';
						}
						else if(i==0 && j==0) {
							continue;
						}
						else {
							ch = chess[i+a][j+b];
						}
					}
				}
				
				if(min > count) min = count;
				if(min > count2) min = count2;
			}
		}
		bw.write(String.valueOf(min));
		
		bw.flush();
		bw.close();
	}

}
