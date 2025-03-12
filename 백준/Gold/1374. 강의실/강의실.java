import java.io.*;
import java.util.*;

public class Main{
    static class Time implements Comparable<Time>{
        int num;
        int start;
        int end;
        
        public Time() {}
        
        public Time(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time t){
            if (this.start == t.start)
            	return this.end - t.end;
            return this.start - t.start;
        }
    }
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Time> times = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            String[] info = br.readLine().split(" ");
            times.add(new Time(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2])));
        }
        
        Collections.sort(times);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int max = 1;

        for (int i = 0; i < n; i++){
            while (!q.isEmpty() && q.peek()<=times.get(i).start){
                q.poll();
            }
            q.offer(times.get(i).end);
            max = Math.max(max, q.size());
        }

        System.out.println(max);
        br.close();
    }

}