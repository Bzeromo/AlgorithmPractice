import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        // 주어진 x = r1 , y = c1 좌표를 for 문을 돌려서 . 인지 알파벳인지 판별 
        // r2 , c2 좌표 까지 
        for(int i = 0, s = r1; i < r2 -r1 +1; i++,s++){
            for(int j = 0, t = c1; j < c2 - c1 +1; j++, t++){
                int x = s % (2 * n - 1); // 마름모 도형에서 0,0 좌표로 부터 상대적으로 x 좌표 계산 
                int y = t % (2 * n - 1); // 마름모 도형에서 0,0 좌표로 상대적으로 y 좌표 계산 
                // 도형의 크키가 2N -1 때문에 도형의 크기 / 주어진 좌표 나머지 -> 마름모에서 상대적인 x , y 좌표 
                int dis = Math.abs(n-1-x) + Math.abs(n-1-y); // 중앙 좌표로 부터 거리 계산
                if(dis > n -1) System.out.print("."); // 다이아몬드 중앙 좌표에서 알파벳 문자까지 최대거리는 N-1 이기 때문에 dis > N - 1 인 경우 알파벳이 아님
                else System.out.print( Character.toString((dis % 26) + 'a') );
            }
            System.out.println();
        }


    }
    // 다이아몬드 별 찍기



}