import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans = 0;
		
		for(int i = 0; i < T; i++) {
			String word = sc.next();
			String wordArr [] = word.split("");
			List<String>list = new ArrayList<>();
			int count = 0;
			String save = wordArr[0];
			
			for(int j = 0; j < wordArr.length; j++) {
				if(save.equals(wordArr[j])) {
					count++;
					continue;
				}
				else {
					if(list.contains(wordArr[j])) break;
					else {
						count++;
						list.add(save);
						save = wordArr[j];
					}
				}
			}
			if(count == wordArr.length) ans++;
		}
		System.out.println(ans);
	}
}

