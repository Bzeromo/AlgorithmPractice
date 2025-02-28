import java.io.*;
import java.util.*;
 
public class Main {    
    static ArrayList<Integer> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr.add(0);
        for (int goal = 1; goal <= 9; goal++) {
            dfs(goal, 0, 0);
        }
        int n = Integer.parseInt(br.readLine());
        if (n == arr.size()) {
            System.out.println("9876543210");
            return;
        }
        try {
            System.out.println(arr.get(n));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(-1);
        }
        
        br.close();
    }
    
    private static void dfs(int goal, int idx, int cur) {
        if (goal == idx) {
            arr.add(cur);
            return;
        }
        int limit = cur==0 ? 9 : (int)(cur%10-1);
        for (int i = cur==0?1:0; i <= limit; i++) {
            int tmp = cur*10+i;
            dfs(goal, idx+1, tmp);
        }
    }
}
