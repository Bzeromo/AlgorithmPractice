import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] tall = new int[n+1];
        List<Integer> ans = new ArrayList<>();
 
        for(int i=1; i<=n; i++) {
            tall[i] = scan.nextInt();
        }
 
        for(int i=n; i>=1; i--) {
            ans.add(tall[i], i);
        }
 
        for(int k : ans) {
            System.out.print(k+" ");
        }
    }
}