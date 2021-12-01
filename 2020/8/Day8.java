import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;

public class Day8{

    static boolean valid(ArrayList<String> list){
        StringTokenizer st;
        HashSet<Integer> visited = new HashSet<Integer>();

        int n = list.size();
        int lineNum = 0;
        int acc = 0;
        while(true){
            if(visited.contains(lineNum)) return false;
            if(lineNum > n || lineNum < 0) return false;
            else if(lineNum == n) {
                System.out.println("found");
                return true;
            }

            visited.add(lineNum);
            String proc = list.get(lineNum);
            st = new StringTokenizer(proc);

            String inst = st.nextToken();
            int arg = Integer.parseInt(st.nextToken());

            if("acc".equals(inst)) acc += arg;
            else if("jmp".equals(inst)) lineNum += arg - 1;

            lineNum++;
        }

    }

    static int run(ArrayList<String> list){
        StringTokenizer st;
        HashSet<Integer> visited = new HashSet<Integer>();

        int n = list.size();
        int lineNum = 0;
        int acc = 0;
        while(!visited.contains(lineNum) && lineNum != n){
            visited.add(lineNum);
            String proc = list.get(lineNum);
            st = new StringTokenizer(proc);

            String inst = st.nextToken();
            int arg = Integer.parseInt(st.nextToken());

            if("acc".equals(inst)) acc += arg;
            else if("jmp".equals(inst)) lineNum += arg - 1;

            lineNum++;
        }
        return acc;
    }

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day8.txt"));
         StringTokenizer st;

         ArrayList<String> list = new ArrayList<String>();
         String line;

         while((line = br.readLine()) != null) list.add(line);

         System.out.println(run(list));
         System.out.println(valid(list));


         int n = list.size();
         for(int i = 0; i < n; i++){
             String proc = list.get(i);
             st = new StringTokenizer(proc);

             String inst = st.nextToken();
             int arg = Integer.parseInt(st.nextToken());

             if("jmp".equals(inst)) list.set(i, "nop " + arg);
             else if ("nop".equals(inst)) list.set(i, "jmp " + arg);

             if(valid(list)) break;
             else list.set(i, proc);
         }

         System.out.println(run(list));
     }

}
