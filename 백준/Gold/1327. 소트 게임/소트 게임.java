import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Solution.solve();
	}
}

class Solution {
	static int N, K, answer;
	static int arr[];
	
	public static void solve() throws IOException {
		input();
		calc();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	static void calc() {
		answer = bfs();
    }
	
	static void output() {
		System.out.println(answer);
	}
	
	static int bfs() {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        queue.add(new State(arr, 0));
        visited.add(Arrays.toString(arr));

        while(!queue.isEmpty()) {
            State current = queue.poll();
            int[] now = current.arr;
            int count = current.count;

            if(Arrays.equals(now, sortedArr)) {
                return count;
            }

            for(int i = 0; i <= N - K; i++) {
                int[] next = now.clone();
                reverse(next, i, i + K - 1);

                if(!visited.contains(Arrays.toString(next))) {
                    queue.add(new State(next, count + 1));
                    visited.add(Arrays.toString(next));
                }
            }
        }
        return -1;
    }
	
	static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

class State {
	int[] arr;
    int count;

    State(int[] arr, int count) {
        this.arr = arr.clone();
        this.count = count;
    }
}