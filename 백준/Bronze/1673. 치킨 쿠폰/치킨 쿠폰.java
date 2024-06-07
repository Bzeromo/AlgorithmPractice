import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //	EOF처리
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int temp = n, add_coupon = 0;
            while(temp >= k){
                add_coupon += temp / k;
                //	새롭게 얻게되는 쿠폰에서 생기는 도장 + 기존에 남은 도장
                temp = temp/k + temp%k;
            }
            System.out.println(n+add_coupon);    
        }
    }
}