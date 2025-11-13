import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static ArrayList<char[]> dic;

    public static void main(String[] args) throws IOException {
       dic = new ArrayList<>();
        
       while(true){
           char[] dic_info = new char[26];
           String s = br.readLine();
           if(s.equals("-")){
               break;
           }else{
               for(int i=0; i<s.length(); i++){
                   char c = s.charAt(i);
                   dic_info[c-65] += 1;
               }
               dic.add(dic_info);
           }
       }
        
       while(true){
           String s = br.readLine();
           StringBuilder sb = new StringBuilder();
           if(s.equals("#")){
               break;
           }else{
               char[] s_info  = new char[26];
               for(int i=0; i<s.length(); i++){
                   char c = s.charAt(i);
                   s_info[c-65] += 1;
               }
               int min = Integer.MAX_VALUE;
               int max = Integer.MIN_VALUE;
               int[] result = new int[26];
               for(int i=0; i<dic.size(); i++){
                   char[] chars = dic.get(i);
                   if(!check(chars, s_info)){
                       continue;
                   }
                   for(int j=0; j<26; j++){
                       if(chars[j] != 0){
                           result[j] += 1;
                       }
                   }

               }
               for(int i=0; i<26; i++){
                   if(s_info[i] == 0){
                       continue;
                   }
                   if(min > result[i]){
                       min = result[i];
                   }
                   if(max < result[i]){
                       max = result[i];
                   }
               }
               for(int i=0; i<26; i++){
                  if(s_info[i] != 0 && result[i] == min){
                      sb.append((char)('A' + i));
                  }
               }
               sb.append(' ').append(min).append(' ');
               for(int i=0; i<26; i++){
                   if(s_info[i] != 0 && result[i] == max){
                       sb.append((char)('A' + i));
                   }
               }
               sb.append(' ').append(max);
               System.out.println(sb);
           }
       }
       br.close();
    }
    static boolean check(char[] arr1, char[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i] > arr2[i]){
                return false;
            }
        }
        return true;
    }

}