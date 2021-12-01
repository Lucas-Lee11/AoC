import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Day1{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day1.txt"));
         ArrayList<Integer> arr = new ArrayList<Integer>();
         StringTokenizer st;

         String line = br.readLine();
         while(line != null){

             st = new StringTokenizer(line);
             arr.add(Integer.parseInt(st.nextToken()));

             line = br.readLine();
         }

         for(Integer i : arr){
             for(Integer j : arr){
                 if (i != j && i + j == 2020) System.out.println(i*j);
                 for(Integer k : arr){
                     if (i + j + k == 2020) System.out.println(i*j*k);
                 }
             }
         }
     }

}
