import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Integer [] student = new Integer[30];
		
		for(int i = 0; i < 30; i++) {
			student[i] = i+1;
		}
		
		List<Integer>studentList = new ArrayList<>(Arrays.asList(student));
		
		for(int i = 0; i < 28; i++) {
			int n = Integer.parseInt(bf.readLine());
			if(studentList.contains(n)) {
				studentList.remove(studentList.indexOf(n));
			}
		}
		
		Iterator<Integer> iterator = studentList.iterator();
		while(iterator.hasNext()) {
			bw.write(iterator.next() + "\n");
		}
		bw.flush();
		bw.close();
	}

}