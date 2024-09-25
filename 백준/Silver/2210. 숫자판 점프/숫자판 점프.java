import java.io.*;
import java.util.*;

public class Main {
	public static int [][] map;
	public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int [] arr ;
    public static ArrayList<String> list;
	public static void main(String[] args ) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		
		map = new int [5][5]; 
		arr= new int [6]; 
		for (int i = 0; i < 5; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		list = new ArrayList<>();
		for(int i = 0 ; i < 5 ; i++) 
			for(int j = 0 ; j < 5 ; j++) 
				dfs(i,j,1);
			
		
		System.out.println(list.size());
	}
	
	public static void dfs(int x, int y , int depth) {
		if(depth > 6) {
			String str = "";
			for(int i = 0 ; i<arr.length; i++) 
				str+= Integer.toString(arr[i]);
			
			if(list.indexOf(str) < 0)
				list.add(str);
			
			return;
		}
		
		
		arr[depth-1] = map[x][y];
		
		for(int i = 0 ; i < 4 ; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<5 && ny>=0 && ny<5) 
				dfs(nx,ny,depth+1);
			
		}
	}
}