import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		StringTokenizer st = new StringTokenizer(s1); 
		StringTokenizer sk = new StringTokenizer(s2);
        
		int ax,ay,az,bx,by,bz,cx,cy,cz;
        
		ax = Integer.parseInt(st.nextToken());
		ay = Integer.parseInt(st.nextToken());
		az = Integer.parseInt(st.nextToken());
		cx = Integer.parseInt(sk.nextToken());
		cy = Integer.parseInt(sk.nextToken());
		cz = Integer.parseInt(sk.nextToken());
		
		bx = cx - az;
		by = cy / ay;
		bz = cz - ax;
		
		System.out.println(bx + " " + by + " " + bz);
        br.close();
	}

}