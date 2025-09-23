import java.io.*;
import java.util.*;

public class Main{
    
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String input;
		int n;
		long oneNumber,cnt;
		
		while((input = br.readLine()) != null){
			n = Integer.parseInt(input);
			oneNumber = 1;
            cnt = 1;
            
			while(true){
				if(oneNumber % n == 0){
					System.out.println(cnt);
					break;
				}
				else{
					oneNumber = (oneNumber * 10) + 1;
					oneNumber %= n;
					cnt++;
				}
			}
		}
        br.close();
	}
}