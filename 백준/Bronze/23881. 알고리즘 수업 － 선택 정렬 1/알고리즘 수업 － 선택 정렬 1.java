import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, kth1 = -1, kth2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N +1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        selectionSort(arr);
        System.out.println(kth1==-1?-1:(kth1 + " " + kth2));
        br.close();
    }
    
    static void selectionSort(int[] A) {
        int swapCnt = 0;
        for (int last = N; last >= 2; last--) {
            int max = Integer.MIN_VALUE;
            int i = 0;
            
            for (int idx = 1; idx <= last; idx++) {
                if (max < A[idx]) {
                    max = A[idx];
                    i = idx;
                }
            }

            if (last != i) {
                int tmp = A[last];
                A[last] = A[i];
                A[i] = tmp;

                if (++swapCnt == K) {
                    kth1 = A[i];
                    kth2 = A[last];
                    return;
                }
            }
        }
    }
}