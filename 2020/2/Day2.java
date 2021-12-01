import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Day2{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day2.txt"));
         StringTokenizer st;

         String line = br.readLine();
         int correct1 = 0;
         int correct2 = 0;

         while(line != null){

             st = new StringTokenizer(line, " :-");
             int low = Integer.parseInt(st.nextToken());
             int high = Integer.parseInt(st.nextToken());
             char letter  = st.nextToken().charAt(0);
             String pass = st.nextToken();

             int count = 0;
             for(int i = 0; i < pass.length(); i++) if(pass.charAt(i) == letter) count++;
             if(count >= low && count <= high) correct1++;

             if((pass.charAt(low-1) == letter ? 1 : 0) + (pass.charAt(high-1) == letter ? 1 : 0) == 1) correct2++;

             line = br.readLine();
         }

         System.out.println(correct1);
         System.out.println(correct2);


     }

}
