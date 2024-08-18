import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int s = sc.nextInt();
    int k = sc.nextInt();
    int div = s / k;
    int quo = s % k;
    long sum = 1;

    for(int i = 1; i <= k; i++) {
      if(i <= quo) sum *= div + 1;
      else sum *= div;
    }
    
    System.out.println(sum);
  }
}