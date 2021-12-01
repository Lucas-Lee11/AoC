import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

public class Day10{

    static long permutations(List<Integer> list, HashMap<Integer,Long> paths, int start){
        if(start==list.size()-1) return 1;
        else if(paths.containsKey(start)) return paths.get(start);
        else{
            long ways = 0;
            for(int i = start + 1; i < list.size() && (list.get(i) - list.get(start)) <= 3; i++) ways += permutations(list, paths, i);
            paths.put(start, ways);
            return ways;
        }

    }

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day10.txt"));

         List<Integer> list = new ArrayList<Integer>();
         String line;
         while((line = br.readLine()) != null) list.add(Integer.parseInt(line));

         Collections.sort(list);
         list.add(0,0);
         list.add(list.get(list.size()-1) + 3);

         int one = 0; int three = 0;
         for(int i = 1; i < list.size(); i++){
             int diff = list.get(i) - list.get(i-1);
             if(diff == 1) one++;
             else if(diff == 3) three++;
         }

         System.out.println(one*three);
         System.out.println(permutations(list, new HashMap<Integer,Long>(), 0));

     }

}
