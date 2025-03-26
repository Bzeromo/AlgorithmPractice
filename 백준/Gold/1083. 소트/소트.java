import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, S, cnt = 0;
	static int arr[];
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		
		br.close();
	}
	
	static void output() {
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void calc() {
		for (int i = 0; i < N && S > 0; i++) {
            int maxIdx = i;
            
            for (int j = i + 1; j < N && j - i <= S; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

            S -= (maxIdx - i);
        }
	}
}