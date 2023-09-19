import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	static int N, whiteCnt, blueCnt;
	static int arr [][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		whiteCnt = 0;
		blueCnt = 0;
		
		arr = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(0, 0, N, N, N);
		
		sb.append(whiteCnt).append("\n").append(blueCnt);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	static void paper(int startX, int startY, int endX, int endY, int N) {
		if(N == 0)
			return;
		
		int search = arr[startX][startY];
		
		for(int i = startX; i < endX; i++) {
			for(int j = startY; j < endY; j++) {
				if(search != arr[i][j]) {
//`					paper(i/(N/2)*(N/2), j/(N/2)*(N/2), i/(N/2)*(N/2)+(N/2-1), j/(N/2)*(N/2)+(N/2-1), N/2);
					paper(startX, startY, endX - N/2, endY - N/2, N/2);
					paper(startX + N/2, startY, endX, endY - N/2, N/2);
					paper(startX, startY + N/2, endX - N/2, endY, N/2);
					paper(startX + N/2, startY + N/2, endX, endY, N/2);
					return;
				}
			}
		}
		
		if(search == 1)
			blueCnt++;
		else
			whiteCnt++;
	}
}

