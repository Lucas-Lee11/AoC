import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Day18{

    private static long eval(String eq){
        long total = 0;
        char op = '\0';

        for(int i = 0; i < eq.length(); i++) {
            char c = eq.charAt(i);
            long v = Character.getNumericValue(c);
            if(c == ' ') continue;
            else if(c == '('){
                int np = 0;
                for(int j = i + 1; j < eq.length(); j++){
                    char k = eq.charAt(j);
                    if(k == '(') np++;
                    else if(k == ')'){
                        if(np == 0){
                            v = eval(eq.substring(i + 1, j));
                            i = j;
                            break;
                        }
                        else np--;
                    }
                }
            }

            if(c == '*' || c == '+') op = c;
            else if(op == '\0') total += v;
            else{
                if(op == '+') total += v;
                else total *= v;
            }
        }
        return total;

    }

    private static long eval2(String eq){
        long total = 0;

        for(int i = 0; i < eq.length(); i++) {
            char c = eq.charAt(i);
            long v = Character.getNumericValue(c);
            if(c == ' ' || c == '+') continue;
            else if(c == '('){
                int np = 0;
                for(int j = i + 1; j < eq.length(); j++){
                    char k = eq.charAt(j);
                    if(k == '(') np++;
                    else if(k == ')'){
                        if(np == 0){
                            total += eval2(eq.substring(i + 1, j));
                            i = j;
                            break;
                        }
                        else np--;
                    }
                }
            }

            else if(c == '*'){
                total *= eval2(eq.substring(i+1, eq.length()));
                break;
            }
            else total += v;

        }
        return total;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day18.txt"));
        StringTokenizer st;
        String line;

        long sum1 = 0, sum2 = 0;
        while((line = br.readLine()) != null){
            sum1 += eval(line);
            sum2 += eval2(line);
        }


        System.out.println(sum1);
        System.out.println(sum2);

    }
}
