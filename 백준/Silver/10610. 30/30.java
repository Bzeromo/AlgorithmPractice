import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String arr[] = br.readLine().split("");

        boolean flag = false;
        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for(String num : arr){
            if(num.equals("0")) flag = true;

            sum += Integer.parseInt(num);
            numbers.add(Integer.parseInt(num));
        }
        
        if(flag){
            if(sum % 3 == 0){
                numbers.sort(Comparator.reverseOrder());
                for (Integer number : numbers) {
                    bw.write(String.valueOf(number));
                }
            }else{
                bw.write("-1");
            }
        }else{
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}