import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sub = y - x;
        
        if(sub == 0){				
            System.out.println(0);
            return;
        }
 
        long N = 1;			
        long ans = 0;
 
        while(N*N <= sub){ 			
            N++;
        }
        N-=1;				
        ans = 2*N - 1;				
 
        sub -= N*N;			
        while(sub > 0){
 
            for(long i = N; 1<=i; i--){		
                if(i<=sub){					
                    ans+=1;
                    sub -= i;			
                    break;
                }
                else continue;				
            }
        }
        System.out.println(ans);
    }
 
}