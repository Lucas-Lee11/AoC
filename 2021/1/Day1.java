import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Day1{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day1.txt"));

         String line = br.readLine();
         StringTokenizer st = new StringTokenizer(line);
         int pre3 = Integer.parseInt(st.nextToken());

         line = br.readLine();
         st = new StringTokenizer(line);
         int pre2 = Integer.parseInt(st.nextToken());

         line = br.readLine();
         st = new StringTokenizer(line);
         int pre1 = Integer.parseInt(st.nextToken());

         int preSum = pre3 + pre2 + pre1;

         int count = 0;
         line = br.readLine();
         while(line != null){

             st = new StringTokenizer(line);

             int cur = Integer.parseInt(st.nextToken());
             int curSum = cur + pre1 + pre2;

             if(curSum > preSum) count++;

             preSum = curSum;
             pre2 = pre1;
             pre1 = cur;
             line = br.readLine();
         }

         System.out.println(count);
     }

}
