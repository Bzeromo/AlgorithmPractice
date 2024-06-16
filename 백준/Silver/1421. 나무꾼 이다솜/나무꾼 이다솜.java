import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int w = Integer.parseInt(str[2]);
    
		int[] len = new int[n];
		int max = -1;
		long ans = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());

			len[i] = next;
			max = Math.max(max, len[i]);
		}

		for (int i = 1; i <= max; i++) {
			long sum = 0;

			for (int j = 0; j < n; j++) {
				int cnt = 0;

				if (len[j] >= i) {      
					if (len[j] % i == 0) {
						cnt = len[j] / i - 1; 
					} else
						cnt = len[j] / i; 

					int temp = w * i * (len[j] / i) - cnt * c;

					if (temp > 0)
						sum += temp;
				}

			}

			ans = Math.max(ans, sum);
		}
		bw.write(ans + "\n");
		bw.close();
        br.close();
	}

}