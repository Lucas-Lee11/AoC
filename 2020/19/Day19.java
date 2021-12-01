import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Day19{

    static int size = 150;
    static ArrayList<ArrayList<ArrayList<Integer>>> rules = new ArrayList<ArrayList<ArrayList<Integer>>>();
    static char[] letters = new char[size];

    private static boolean valid(String s, ArrayDeque<Integer> stack){
        int i = 0;
        if(s.length() == 0) return false;
        while(!stack.isEmpty() && i < s.length()){
            int check = stack.pop();
            ArrayList<ArrayList<Integer>> adj = rules.get(check);

            if(adj == null){
                if(s.charAt(i) == letters[check]) i++;
                else return false;
            }
            else{
                if(adj.size() == 1)for(Integer r : adj.get(0)) stack.push(r);
                else{
                    String t = s.substring(i, s.length());
                    for(ArrayList<Integer> p : adj){
                        ArrayDeque<Integer> temp = stack.clone();
                        for(Integer r : p) temp.push(r);
                        if(valid(t, temp)) return true;
                    }
                    return false;
                }
            }
        }
        return (stack.isEmpty() && i == s.length());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day19.txt"));
        StringTokenizer st;
        String line;

        for(int i = 0; i < size; i++) rules.add(null);
        while(!"".equals(line = br.readLine())){
            st = new StringTokenizer(line, ":");
            int num = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(st.nextToken());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> p = new ArrayList<Integer>();
            while(st.hasMoreTokens()){
                String s = st.nextToken();
                if(s.charAt(0) == '"') letters[num] = s.charAt(1);
                else if(s.charAt(0) == '|'){
                    adj.add(p);
                    p = new ArrayList<Integer>();
                }
                else{
                    int n = Integer.parseInt(s);
                    p.add(0,n);
                }
            }
            if(letters[num] == 0){
                adj.add(p);
                rules.set(num, adj);
            }

        }

        ArrayList<String> messages = new ArrayList<String>();
        while((line = br.readLine()) != null) messages.add(line);

        int sum1 = 0;
        for(String message : messages){
            ArrayDeque<Integer> zero = new ArrayDeque<Integer>();
            zero.push(0);
            if (valid(message, zero)) sum1++;
        }
        System.out.println(sum1);

        ArrayList<Integer> p1 = new ArrayList<Integer>(); p1.add(42);
        ArrayList<Integer> p2 = new ArrayList<Integer>(); p2.add(8); p2.add(42);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); adj.add(p1);adj.add(p2);
        rules.set(8, adj);

        p1 = new ArrayList<Integer>(); p1.add(31); p1.add(42);
        p2 = new ArrayList<Integer>(); p2.add(31); p2.add(11); p2.add(42);
        adj = new ArrayList<ArrayList<Integer>>(); adj.add(p1);adj.add(p2);
        rules.set(11, adj);

        int sum2 = 0;
        for(String message : messages){
            ArrayDeque<Integer> zero = new ArrayDeque<Integer>();
            zero.push(0);
            if (valid(message, zero)) sum2++;
        }
        System.out.println(sum2);





    }
}
