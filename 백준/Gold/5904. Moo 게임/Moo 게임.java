import java.awt.image.BufferedImageFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static char answer;

    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);

        int num=scan.nextInt();


        Moo(num);

        System.out.println(answer);

        scan.close();


    }

    public static void Moo(int num){
        int size=3;
        int index=0;

        if(num==1){
            answer='m';
        }else if(num<=3)
            answer='o';
        else{
            while(size<num){
                size=size*2+index+4;
                index++;
            }

            int front_back=(size-index-3)/2;



            if(size-front_back+1<=num){
                Moo(num-size+front_back);
            }else if(num==front_back+1)
                answer='m';
            else
                answer='o';
        }


    }




}
