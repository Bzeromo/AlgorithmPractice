import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> map = new HashMap<>();
		map.put("-", 0);
		map.put("\\", 1);
		map.put("(", 2);
		map.put("@", 3);
		map.put("?", 4);
		map.put(">", 5);
		map.put("&", 6);
		map.put("%", 7);
		map.put("/", -1);

		while (true) { // 라인별 접근을 위한 순한
			String N = sc.nextLine(); // 라인별 접근
			if (N.equals("#")) // 만약 0이라면
				System.exit(0); // 시스템 강제 종료 코드

			String[] arr = N.split(""); // 해당 문자열 한글자씩 배열 생성

			int sum = 0;
			int num = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += map.get(arr[i]) * Math.pow(8, arr.length - 1 - i);
			}
			System.out.println(sum);
		}
	}
}