import java.io.*;
import java.util.*;
 
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      
    while (true) {
      int N = sc.nextInt();
      if (N == 0) break;
      
      System.out.println(countUniqueSquares(N));
    }
    
    sc.close();
  }
    
  private static int countUniqueSquares(int N) {
    int totalSquares = 0;
      
    for (int k = 1; k <= N; k++) {
      totalSquares += (N - k + 1) * (N - k + 1);
    }
    return totalSquares;
  }
}