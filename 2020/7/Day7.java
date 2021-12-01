import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Day7{

    static boolean containsTarget(HashMap<String, HashMap<String, Integer>> bags, String current, String target){
        HashMap<String, Integer> contents = bags.get(current);
        boolean temp = false;

        if(contents.containsKey(target)) return true;
        else if(contents.isEmpty()) return false;
        else for (String bag : contents.keySet()) {
            temp = temp || containsTarget(bags, bag, target);
        }

        return temp;

    }

    static int totalBags(HashMap<String, HashMap<String, Integer>> bags, String target){
        HashMap<String,Integer> contents = bags.get(target);
        int sum = 1;

        for(String bag : contents.keySet()){
            sum +=  contents.get(bag) * totalBags(bags, bag);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day7.txt"));
         StringTokenizer st;

         HashMap<String, HashMap<String, Integer>> bags = new HashMap<String, HashMap<String, Integer>>();

         String line;
         while((line = br.readLine()) != null){
             st = new StringTokenizer(line, " .,");

             HashMap<String, Integer> contains = new HashMap<String, Integer>();
             String outer = st.nextToken() + st.nextToken();
             st.nextToken(); st.nextToken();


             while(st.hasMoreTokens()){
                 String test = st.nextToken();
                 if(test.equals("no")) break;

                 int num = Integer.parseInt(test);
                 String inner = st.nextToken() + st.nextToken();
                 contains.put(inner,num);

                 st.nextToken();
             }
             bags.put(outer, contains);

         }

         int sum = 0;
         for (String bag : bags.keySet()) if(containsTarget(bags, bag, "shinygold")) sum++;


         System.out.println(sum);
         System.out.println((totalBags(bags, "shinygold") - 1));


     }

}
