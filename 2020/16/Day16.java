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

public class Day16{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day16.txt"));
        StringTokenizer st;
        String line;

        ArrayList<HashSet<Integer>> dfields = new ArrayList<HashSet<Integer>>();
        HashSet<Integer> all = new HashSet<Integer>();
        while(!"".equals((line = br.readLine()))){
            st = new StringTokenizer(line, ":");
            HashSet<Integer> arr = new HashSet<Integer>();
            String field = st.nextToken();
            String vals = st.nextToken();

            st = new StringTokenizer(vals, " -");
            int l1 = Integer.parseInt(st.nextToken());
            int h1 = Integer.parseInt(st.nextToken());
            st.nextToken();
            int l2 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());

            for(int i = l1; i <= h1; i++) arr.add(i);
            for(int i = l2; i <= h2; i++) arr.add(i);
            dfields.add(arr);
            all.addAll(arr);
        }
        br.readLine();

        ArrayList<Integer> personal = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine(), ",");
        while(st.hasMoreTokens()) personal.add(Integer.parseInt(st.nextToken()));
        br.readLine();
        br.readLine();

        int sum = 0;
        ArrayList<ArrayList<Integer>> tickets = new ArrayList<ArrayList<Integer>>();
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line,",");

            ArrayList<Integer> ticket = new ArrayList<Integer>();
            boolean valid = true;
            while(st.hasMoreTokens()){
                int i = Integer.parseInt(st.nextToken());
                ticket.add(i);
                if(!all.contains(i)){
                    sum += i;
                    valid = false;
                    break;
                }
            }
            if(valid) tickets.add(ticket);
        }
        System.out.println(sum);

        ArrayList<ArrayList<Integer>> poss = new ArrayList<ArrayList<Integer>>();
        for(HashSet h : dfields){
            ArrayList<Integer> p = new ArrayList<Integer>();
            for(int i = 0; i < tickets.get(0).size(); i++){
                boolean flag = true;
                for(ArrayList<Integer> ticket : tickets) if(!h.contains(ticket.get(i))){
                    flag = false;
                    break;
                }
                if(flag) p.add(i);
            }
            poss.add(p);
        }


        int[] fin = new int[poss.size()];
        while(true){
            boolean flag = true;
            int index = 0;
            ArrayList<Integer> s = new ArrayList<Integer>();
            for(int i = 0; i < poss.size(); i++) {
                ArrayList<Integer> c = poss.get(i);
                if(c.size() == 1){
                    s = c;
                    index = i;
                }
                else if(poss.get(i).size() > 1) flag = false;
            }
            if(flag){
                fin[index] = s.get(0);
                break;
            }
            for(ArrayList<Integer> i : poss) if(i != s) i.removeAll(s);
            fin[index] = s.get(0);
            s.remove(0);
        }

        long prod = 1;
        for(int i = 0; i < 6; i++) prod *= personal.get(fin[i]);
        System.out.println(prod);

    }
}
