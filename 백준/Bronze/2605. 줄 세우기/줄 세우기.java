import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        List<Integer> students = new LinkedList<>();
 
        for(int i = 0; i < N; i++){
            students.add(i - Integer.parseInt(st.nextToken()),i+1);
        }
 
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            sb.append(students.get(i)).append(" ");
        }
 
        System.out.println(sb);
        br.close();
    }
}