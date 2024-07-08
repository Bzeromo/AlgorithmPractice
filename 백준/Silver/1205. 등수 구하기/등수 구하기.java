import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        if(n == 0) {    //n이 0이라면 기존 rank에 있는 값이 없으므로 해당 입력값이 1위가 된다.
            System.out.println(1);
            return;
        }
        
        StringTokenizer s = new StringTokenizer(br.readLine());
        ArrayList<Integer> ranklist = new ArrayList<Integer>();    //랭킹 리스트 생성
        
        for(int i = 0; i < n; i++) {
            ranklist.add(Integer.parseInt(s.nextToken()));
        }
        
        int rank = 1;
        if(ranklist.size() == p && point <= ranklist.get(ranklist.size()-1)) {    // 등재가능한 랭킹리스트가 가득 차 있고 입력값이 그 최하위 값과 같거나 작다면 -1을 출력한다.
            System.out.println(-1);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(point >= ranklist.get(i)) {    // 랭킹 리스트의 특정 값보다 크거나 같다면 입력값의 순위는 i+1위가 된다.
                rank = i + 1;
                break;
            }else {                            // 랭킹 리스트의 특정 값보다 작은 경우 순위를 한단계 낮추고 다음 값과 비교한다.
                rank++;
            }
        }
        
        if(rank <= p) {                        //정해진 rank가 랭킹 리스트에 들어갈 수 있는 순위이면 rank를 출력 아닌경우 -1 출력
            System.out.println(rank);
        }else {
            System.out.println(-1);
        }
    }
 
}
