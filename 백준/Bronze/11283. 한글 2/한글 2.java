import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char hangul = br.readLine().charAt(0);

		System.out.println((int) hangul - 44031); 
        br.close();
	}

}