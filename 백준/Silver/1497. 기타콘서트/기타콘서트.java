import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, minGuitarCount = Integer.MAX_VALUE;
    static int max = 0;
    static long[] guitarBit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitarBit = new long[N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            st.nextToken();
            char[] guitarTF = st.nextToken().toCharArray();
            for(int j=0;j<M;j++){
                if (guitarTF[j] == 'Y') {
                    guitarBit[i] |= (1L<<j);
                }
            }
        }
        search(0,  0L, 0);
        
        if (minGuitarCount == 0) {
            minGuitarCount = -1;
        }
        
        bw.write(String.valueOf(minGuitarCount));
        bw.close();
        br.close();
    }
    
    static void search(int idx, long guitarMask, int val){
        int bitCount = Long.bitCount(guitarMask);
       
        if(bitCount == max && val < minGuitarCount) {
            minGuitarCount = val;
        }
        
        if(bitCount > max) {
            minGuitarCount = val;
            max = bitCount;
        }
        
        if(bitCount == M || idx == N){
            return;
        }

        search(idx+1, guitarMask | guitarBit[idx], val+1);
        search(idx+1, guitarMask, val);
    }
}