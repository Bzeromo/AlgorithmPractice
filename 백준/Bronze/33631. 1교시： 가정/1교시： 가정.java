import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Fn = Integer.parseInt(st.nextToken());
        int Cn = Integer.parseInt(st.nextToken());
        int En = Integer.parseInt(st.nextToken());
        int Bn = Integer.parseInt(st.nextToken());

        int Q = Integer.parseInt(br.readLine());
        int cookieCount = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            switch (type) {
                case 1:
                    int needF = Fn * value;
                    int needC = Cn * value;
                    int needE = En * value;
                    int needB = Bn * value;

                    if (F >= needF && C >= needC && E >= needE && B >= needB) {
                        F -= needF;
                        C -= needC;
                        E -= needE;
                        B -= needB;
                        cookieCount += value;
                        sb.append(cookieCount).append('\n');
                    } else {
                        sb.append("Hello, siumii").append('\n');
                    }
                    break;

                case 2:
                    F += value;
                    sb.append(F).append('\n');
                    break;

                case 3:
                    C += value;
                    sb.append(C).append('\n');
                    break;

                case 4:
                    E += value;
                    sb.append(E).append('\n');
                    break;

                case 5:
                    B += value;
                    sb.append(B).append('\n');
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
