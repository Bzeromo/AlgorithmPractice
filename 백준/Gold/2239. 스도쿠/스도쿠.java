import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int sudoku[][];
    static StringBuilder sb = new StringBuilder();;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        sudoku = new int [9][9];
        
        for(int i = 0; i < 9; i++) {
            String st = br.readLine();
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = st.charAt(j)-'0';
            }
        }
        
        br.close();
        game(0,0);
    }
    
    static void game(int x, int y) throws IOException {
        if(y == 9) {
            game(x+1, 0);
            return;
        }
        
        if(x == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]);
                    
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.close();
            System.exit(0);   
        }
        
        if(sudoku[x][y] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(isPossible(x, y, i)) {
                    sudoku[x][y] = i;
                    game(x, y+1);
                }
            }
            sudoku[x][y] = 0;
            return;
        }
        
        game(x, y+1);
    }
    
    static boolean isPossible(int x, int y, int num) {
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][y] == num)
                return false;
        }
        
        for(int i = 0; i < 9; i++) {
            if(sudoku[x][i] == num)
                return false;
        }
        
        int naemo_x = (x / 3) * 3;
        int naemo_y = (y / 3) * 3;
        
        for(int i = naemo_x; i < naemo_x+3; i++) {
            for(int j = naemo_y; j < naemo_y+3; j++) {
                if(sudoku[i][j] == num)
                    return false;
            }
        }
        
        return true;
    }

}