import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Day3{

    public static void main(String[] args) throws IOException{

         BufferedReader br = new BufferedReader(new FileReader("./Day3.txt"));
         StringTokenizer st;

         String line = br.readLine();
         line = br.readLine();


         long num = 2;
         int slope11 = 1; int slope31 = 3; int slope51 = 5; int slope71 = 7; int slope12 = 1;
         long trees11 = 0; long trees31 = 0; long trees51 = 0; long trees71 = 0; long trees12 = 0;

         while(line != null){
             String row  = new StringTokenizer(line).nextToken();

             if(row.charAt(slope11) == '#') trees11++;
             if(row.charAt(slope31) == '#') trees31++;
             if(row.charAt(slope51) == '#') trees51++;
             if(row.charAt(slope71) == '#') trees71++;
             if(num % 2 == 1 && row.charAt(slope12) == '#') trees12++;

             slope11 = (slope11 + 1 ) % row.length();
             slope31 = (slope31 + 3 ) % row.length();
             slope51 = (slope51 + 5 ) % row.length();
             slope71 = (slope71 + 7 ) % row.length();
             if(num % 2 == 1) slope12 = (slope12 + 1 ) % row.length();

             line = br.readLine();
             num++;
         }
         long out = trees11*trees31*trees51*trees71*trees12;
         System.out.println(out);


     }

}
