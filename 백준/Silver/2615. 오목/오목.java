import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int board [][] = new int[19][19];
		
		for(int i =0; i < 19; i++) {
			for(int j = 0; j<19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 하 우 북동 남동
		int [] dr = {1, 0, -1, 1};
		int [] dc = {0, 1, 1, 1};
		boolean fin = false;
		int answer =0, x=0, y=0;
		
		for(int i =0; i<19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] == 1) {
					for(int k=0; k < 4; k++) {
						if(i+dr[k] >= 0 && i+dr[k] < 19 && j+dc[k] >=0 && j+dc[k] < 19) {
							if(board[i+dr[k]][j+dc[k]] == 1) {
								int cnt =2;
								for(int l = 2; l <= 5; l++) {
									if(i+dr[k]*l >= 0 && i+dr[k]*l < 19 && j+dc[k]*l >=0 && j+dc[k]*l < 19 && board[i+dr[k]*l][j+dc[k]*l] == 1) {
										cnt++;
									} else if(i+dr[k]*l >= 0 && i+dr[k]*l < 19 && j+dc[k]*l >=0 && j+dc[k]*l < 19 && board[i+dr[k]*l][j+dc[k]*l] != 1) {
										break;
									}
								}
								if(i+dr[k]*(-1) >= 0 && i+dr[k]*(-1) < 19 && j+dc[k]*(-1) >= 0 && j+dc[k]*(-1) < 19 && board[i+dr[k]*(-1)][j+dc[k]*(-1)] != 1 && cnt == 5) {
									fin = true;
									answer = 1;
									x=i+1;
									y=j+1;
									break;
								} else if ((i+dr[k]*(-1) < 0 || i+dr[k]*(-1) >= 19 || j+dc[k]*(-1) < 0 || j+dc[k]*(-1) >= 19) && cnt == 5) {
									fin = true;
									answer = 1;
									x=i+1;
									y=j+1;
									break;
								}
							}
						}
					}
				} else if(board[i][j] == 2) {
					for(int k=0; k < 4; k++) {
						if(i+dr[k] >= 0 && i+dr[k] < 19 && j+dc[k] >=0 && j+dc[k] < 19) {
							if(board[i+dr[k]][j+dc[k]] == 2) {
								int cnt =2;
								for(int l = 2; l <= 5; l++) {
									if(i+dr[k]*l >= 0 && i+dr[k]*l < 19 && j+dc[k]*l >=0 && j+dc[k]*l < 19 && board[i+dr[k]*l][j+dc[k]*l] == 2) {
										cnt++;
									} else if(i+dr[k]*l >= 0 && i+dr[k]*l < 19 && j+dc[k]*l >=0 && j+dc[k]*l < 19 && board[i+dr[k]*l][j+dc[k]*l] != 2) {
										break;
									}
								}
								if(i+dr[k]*(-1) >= 0 && i+dr[k]*(-1) < 19 && j+dc[k]*(-1) >= 0 && j+dc[k]*(-1) < 19 && board[i+dr[k]*(-1)][j+dc[k]*(-1)] != 2 && cnt == 5) {
									fin = true;
									answer = 2;
									x=i+1;
									y=j+1;
									break;
								} else if ((i+dr[k]*(-1) < 0 || i+dr[k]*(-1) >= 19 || j+dc[k]*(-1) < 0 || j+dc[k]*(-1) >= 19) && cnt == 5) {
									fin = true;
									answer = 2;
									x=i+1;
									y=j+1;
									break;
								}
							}
						}
					}
				}
				if(fin) break;
			}
			if(fin) break;
		}
		if(answer != 0) {
			System.out.println(answer + "\n" + x + " " + y);
		} else {
			System.out.println(0);
		}
	}

}
