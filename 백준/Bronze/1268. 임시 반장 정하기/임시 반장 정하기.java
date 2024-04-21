import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] table = new int[n][5];
		boolean[][] list = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				table[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		//1학년부터 5학년까지 반복
		for (int i = 0; i < 5; i++) {
			//반 수는 9반까지 있으니까 10으로 범위 지정
			ArrayList<Integer>[] temp = new ArrayList[10];

			//학년에 따른 학생 반복 (해당 학년 때 같은 반인 학생들 모으기 위한 for문)
			for (int j = 0; j < n; j++) {
				//만약 j번 학생의 i학년의 반에 대한 array가 없을 때 새로 만들기
				if (temp[table[j][i]] == null) temp[table[j][i]] = new ArrayList<>();
				//array에 j번 추가
				temp[table[j][i]].add(j);
			}
			
			//학년에 따른 학생 반복 (해당 학년 때 같은 반인 학생 체크하기 위한 for문)
			for (int j = 0; j < n; j++) {
				//몇 반이었는지 가져오기
				int num = table[j][i];

				//같은 반 학생들 리스트 가져오기
				ArrayList<Integer> data = temp[num];

				//학생에 따른 같은 반 학생이었던 학생 체크하기 위한 for문
				for (int k = 0; k < data.size(); k++) {
					if (j == data.get(k)) continue;
					list[j][data.get(k)] = true;
				}
			}
		}
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			int num = 0;
			for (int j = 0; j < n; j++) {
				if (list[i][j]) num++;
			}
			if (max < num) {
				max = num;
				index = i;
			}
		}
		
		System.out.println(index+1);
	}
}