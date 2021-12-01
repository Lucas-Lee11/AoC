import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Day5{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day5.txt"));
         boolean arr[] = new boolean[1024];

         String line;
         int highest = 0;

         while((line = br.readLine()) != null){
             int h = 127; int l = 0;
             for(int i = 0; i < 7; i++){
                 if(line.charAt(i) == 'F') h -= (h-l)/2.0;
                 else l += (h-l)/2.0;
             }
             int row = h;

             h = 7; l = 0;
             for(int i = 7; i < 10; i++){
                 if(line.charAt(i) == 'L') h -= (h-l)/2.0;
                 else l += (h-l)/2.0;
             }
             int col = h;

             int id = row * 8 + col;
             arr[id] = true;
             if(id > highest) highest = id;


         }

         int pid = 0;
         for(int i = 1; i < 1022; i++){
             if(arr[i-1] && arr[i+1] && !arr[i]){
                 pid = i;
                 break;
             }
         }

         System.out.println(highest);
         System.out.println(pid);
     }

}
