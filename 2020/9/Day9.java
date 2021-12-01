import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Day9{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day9.txt"));
         LinkedList<Long> q = new LinkedList<Long>();
         ArrayList<Long> list = new ArrayList<Long>();

         String line;
         for(int i = 0; i < 25; i++) {
             long num = Long.parseLong(br.readLine());
             q.add(num);
             list.add(num);
         }


         long invalid = 0;
         while((line = br.readLine()) != null){
            long num = Long.parseLong(line);
            boolean flag = true;

            long itrack = 0;
            for(Long i : q){
                long jtrack = 0;
                for (Long j : q){
                    if(i + j == num && itrack != jtrack){
                        flag = false;
                        break;
                    }
                    jtrack++;
                }
                if(!flag) break;
                itrack++;
            }

            if(flag){ invalid = num; break;}

            q.add(num);
            q.remove();
            list.add(num);
         }
         System.out.println(invalid);

         List<Long> cont = new ArrayList<Long>();
         int longest = 0;
         for(int i = 0; i < list.size(); i++){
             long sum = list.get(i);
             //System.out.println(sum);
             for(int j = i + 1; j < list.size(); j++){
                 sum += list.get(j);
                 if(sum == invalid){
                     //System.out.println(list.get(i) + "--"+list.get(j));
                     if(j - i + 1 > longest) {
                         cont = list.subList(i, j+1);
                         longest = j - i + 1;
                     }
                     break;
                 }
                 if(sum > invalid) break;
             }

         }

         Collections.sort(cont);
         System.out.println(cont.get(0) + cont.get(cont.size()-1));


     }

}
