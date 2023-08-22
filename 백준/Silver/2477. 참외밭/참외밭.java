import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int turn [] = new int [6];
		int length [] = new int [6];
		int xMax = 0, yMax = 0, xMaxIdx=0, yMaxIdx=0, answer = 0;
		
		for(int tc = 0; tc < 6; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			turn[tc] = Integer.parseInt(st.nextToken());
			length[tc] = Integer.parseInt(st.nextToken());
			
			if(tc%2==0 && xMax < length[tc]) {
				xMax = length[tc];
				xMaxIdx = tc;
			}
			else if(tc%2==1 && yMax < length[tc]) {
				yMax = length[tc];
				yMaxIdx = tc;
			}
		}
		
		if(xMaxIdx==0 && yMaxIdx == 1) {
			answer = (xMax*yMax) - (xMax-length[2])*length[3];
		} else if (xMaxIdx==2 && yMaxIdx == 1) {
			answer = (xMax*yMax) - length[4]*length[5];
		} else if (xMaxIdx==2 && yMaxIdx == 3) {
			answer = (xMax*yMax) - length[0]*(yMax-length[1]);
		} else if(turn[0] == turn[2] && turn[1] == turn[3]) {
			answer = (xMax*yMax) - length[1]*length[2];
		} else if(turn[0] == turn[2]) {
			answer = (xMax*yMax) - length[0]*length[1];
		} else if(turn[1] == turn[3]) {
			answer = (xMax*yMax) - length[2]*length[3];
		} 
		
		StringBuilder sb = new StringBuilder();
		bw.write(sb.append(answer*K).toString());
		bw.close();
	} // main
} // class
