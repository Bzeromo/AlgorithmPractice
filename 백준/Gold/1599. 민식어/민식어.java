import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        IntStream.range(0, N)
                .mapToObj(i -> sc.next().replace("k", "c").replace("ng", "n~"))
                .sorted()
                .map(s -> s.replace("c", "k").replace("n~", "ng"))
                .forEach(System.out::println);
    }
}