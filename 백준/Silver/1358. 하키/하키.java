import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int rad = height/2;
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int player = Integer.parseInt(st.nextToken());
		
		int loc[][] = new int[player][2];		
        
		for(int i = 0; i < player; i++) {
			st = new StringTokenizer(br.readLine());
			loc[i][0] = Integer.parseInt(st.nextToken());
			loc[i][1] = Integer.parseInt(st.nextToken());
		}
        
		int count = 0;
        
		for(int i = 0; i < player; i++) {
			if ((loc[i][0]>=x && loc[i][0]<=(x+width)) && (loc[i][1]>=y && loc[i][1]<=(y+height))) {
				count++;
			}else if (getDist(x, y+rad, loc[i][0], loc[i][1])<=rad) {
				count++;
			}else if (getDist(x+width, y+rad, loc[i][0], loc[i][1])<=rad) {
				count++;
			}else {
				continue;
			}
		}
		System.out.println(count);
        br.close();
	}
    
    static double getDist(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
}