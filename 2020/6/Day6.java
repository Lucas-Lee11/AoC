import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Day6{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day6.txt"));
         StringTokenizer st;

         String line = br.readLine();
         int oneCount = 0;
         int allCount = 0;

         while(line != null){
             HashSet<Character> one = new HashSet<Character>();
             HashSet<Character> all = new HashSet<Character>();

             boolean first = true;
             while(line != null && !"".equals(line)) {
                 HashSet<Character> person = new HashSet<Character>();

                 for(int i = 0; i < line.length(); i++) {
                     char c = line.charAt(i);

                     one.add(c);

                     if(first) all.add(c);
                     else person.add(c);
                 }

                 HashSet<Character> toRemove = new HashSet<Character>();
                 if(!first) for(Character c : all){
                     if(!person.contains(c)) toRemove.add(c);
                 }
                 all.removeAll(toRemove);

                 line = br.readLine();
                 first = false;
             }
             oneCount += one.size();
             allCount += all.size();



             line = br.readLine();
         }


         System.out.println(oneCount);
         System.out.println(allCount);


     }

}
