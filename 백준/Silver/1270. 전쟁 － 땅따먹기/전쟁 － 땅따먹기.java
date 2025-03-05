import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int T = Integer.parseInt(br.readLine());
	    HashMap<Long, Integer> map = new HashMap<>();
	    
	    for(int i = 0; i < T; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int N = Integer.parseInt(st.nextToken());
	    	
	    	int max = 0;
	    	Long idx = 0L;
	    	
	    	for(int j = 0; j < N; j++) {
	    		long n = Long.parseLong(st.nextToken());
	    		
	    		if (map.containsKey(n)) {
					map.replace(n, map.get(n) + 1);
				} else {
					map.put(n, 1);
				}

				if (map.get(n) > max) {
					max = map.get(n);
					idx = n;
				}
	    	}
	    	
	    	if (max > N/2) {
				bw.write(idx + "\n");
			} else {
				bw.write("SYJKGW\n");
			}
	    	map.clear();
	    }
	    
	    bw.close();
	    br.close();
    }
}