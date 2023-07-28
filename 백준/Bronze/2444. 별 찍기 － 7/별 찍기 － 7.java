import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int star = Integer.parseInt(bf.readLine());
		
		for(int i=0; i < star; i++) {
			for(int j=i; j < star-1; j++)
				System.out.print(" ");
			for(int j=star-i-1; j < star; j++)
				System.out.print("*");
			for(int j=star-i; j < star; j++)
				System.out.print("*");
			
			System.out.println();
		}
		
		for(int i=0; i < star-1; i++) {
			for(int j=star-i-1; j < star; j++)
				System.out.print(" ");
			for(int j=i+1; j < star-1; j++)
				System.out.print("*");
			for(int j=i; j < star-1; j++)
				System.out.print("*");
			if(i==star-2) break;
			System.out.println();
		}
	}
}
