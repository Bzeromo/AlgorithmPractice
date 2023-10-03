import java.io.*;
import java.util.*;


public class Main {
	static int N,M,K;
	static ArrayList<Fireball> map[][];
	static ArrayList<Fireball> list = new ArrayList<>();
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<N+1; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new Fireball(r,c,m,s,d));
			list.add(new Fireball(r,c,m,s,d));
		}
		
		//print();
		
		while(K-- > 0) {
			move();
			//print();
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(map[i][j].size() >=2 ) {
						merge(i,j);
						//print();
					}
				}
			}
			makeList();
		}
		
		int ans = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(map[i][j].size() > 0) {
					for(Fireball cur : map[i][j]) {
						//System.out.println(cur.m);
						ans += cur.m;
						
					}
				}
			}
		}
		
		System.out.println(ans);
	}
 	
 	public static void makeList(){
 		list = new ArrayList<>();
 		for(int i=1; i<N+1; i++) {
 			for(int j=1; j<N+1; j++) {
 				if(map[i][j].size() > 0){
 					for(Fireball cur : map[i][j]) {
 						list.add(cur);
 					}
 				}
 			}
 		}
 	}
 	
 	public static void print() {
 		for(int i=1; i<N+1; i++) {
 			for(int j=1; j<N+1; j++) {
 				System.out.print(map[i][j].size() +" ");
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}
	
	public static void move() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				map[i][j] = new ArrayList<Fireball>();
			}
		}
		
		for(Fireball cur : list) {
			cur.r = cur.r+dx[cur.d]*(cur.s%N);
			cur.c = cur.c+dy[cur.d]*(cur.s%N);
			
			if(cur.r > N) cur.r %= N;
			if(cur.c > N ) cur.c %= N;
			if(cur.r <= 0 ) cur.r = N-Math.abs(cur.r);
			if(cur.c <= 0) cur.c = N-Math.abs(cur.c);
			
			map[cur.r][cur.c].add(cur);
		}
		
	}
	
	public static void merge(int x, int y) {
		int sumM=0, sumS=0, sumCnt=0, sumD=0;
		boolean isEven = true;
		boolean isOdd = true;
		for(Fireball cur : map[x][y]) {
			sumM += cur.m;
			sumS += cur.s;
			sumCnt++;
			if(cur.d %2 ==0) {
				isOdd = false;
			}else {
				isEven = false;
			}
		}
		
		int M = sumM/5;
		int S = sumS/sumCnt;
		
		map[x][y] = new ArrayList<>();
		if(M <= 0) {
			return;
		}
		
		if(isEven || isOdd) {
			for(int i=0; i<4; i++) {
				map[x][y].add(new Fireball(x,y,M,S,i*2));
			}
		}else {
			for(int i=0; i<4; i++) {
				map[x][y].add(new Fireball(x,y,M,S,i*2+1));
			}
		}
		
	}
	
	public static class Fireball{
		int r;	// 행
		int c;	// 열
		int m;	// 질량
		int s;	// 속력
		int d;	// 방향
		Fireball(int r,int c,int m, int s,int d){
			this.r = r ;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

}