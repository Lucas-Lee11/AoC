import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Day15{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day15.txt"));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line,",");

        int turn = 0; int last = 0;
        int[] arr = new int[30000000];
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            arr[last] = turn++;
            last = n;
        }

        while(turn != 30000000){
            int c = arr[last];
            if(c != 0){
                int temp = c;
                arr[last] = turn;
                last = turn - temp;

            }
            else {
                arr[last] = turn;
                last = 0;
            }
            turn++;
        }

        System.out.println(last);


    }
}
