import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		String wordArr [] = word.split("");
		int ans = wordArr.length;
		
		for(int i = 0; i < wordArr.length-1; i++) {
			String cro = wordArr[i] + wordArr[i+1];
			if(cro.equals("c=") || cro.equals("c-") || cro.equals("d-") || cro.equals("lj") || cro.equals("nj") || cro.equals("s=") || cro.equals("z=")) ans--;
		}
		
		for(int i = 0; i < wordArr.length-2; i++) {
			String cro = wordArr[i] + wordArr[i+1] + wordArr[i+2];
		
			if(cro.equals("dz=")) ans--;
		}
		
		System.out.println(ans);
	}
}

