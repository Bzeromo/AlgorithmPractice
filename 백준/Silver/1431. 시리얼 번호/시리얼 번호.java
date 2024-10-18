import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }
                    if (sum1 == sum2)
                        return o1.compareTo(o2);
                    else
                        return sum1 - sum2;
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
        br.close();
    }
}