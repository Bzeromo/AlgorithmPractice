import java.io.*;
import java.util.*;

class column implements Comparable<column> {
    public int location;
    public int high;

    public column(int location, int high) {
        this.location = location;
        this.high = high;
    }

    @Override
    public int compareTo(column c) {
        return this.location - c.location;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        column[] columns = new column[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            columns[i] = new column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(columns); 

        int area = 0; 
        int pivot = 0;
        int highIndex = 0;
        
        for (int i = 0 ; i < n; i++) {
            if (columns[pivot].high < columns[i].high) pivot = i;
        }

        for (int i = 0; i <= pivot; i++) {
            if (columns[highIndex].high <= columns[i].high) {
                area += (columns[i].location - columns[highIndex].location) * columns[highIndex].high;
                highIndex = i;
            }
        }

        highIndex = n - 1;
        for (int i = n - 1; i >= pivot; i--) {
            if (columns[highIndex].high <= columns[i].high) {
                area += (columns[highIndex].location - columns[i].location) * columns[highIndex].high;
                highIndex = i;
            }
        }

        area += columns[pivot].high;
        System.out.println(area);
        br.close();
    }
}