import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Day14{

    private static ArrayList<Long> permutations(List<Long> nums){
        ArrayList<Long> out = new ArrayList<Long>();
        if(nums.isEmpty()) out.add((long)0);
        else{
            List<Long> last = permutations(nums.subList(1,nums.size()));
            for(long i : last) {
                out.add(i);
                out.add(nums.get(0) + i);
            }
        }
        return out;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day14.txt"));
        StringTokenizer st;
        String line;

        HashMap<Long,Long> valc = new HashMap<Long,Long>();
        HashMap<Long,Long> addrc = new HashMap<Long,Long>();
        List<Long> masks = new ArrayList<Long>();

        long ovv = 0; long mask = 0; long addrovv = 0;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line, "= []");
            String comm = st.nextToken();

            if("mask".equals(comm)){
                mask = 0; masks = new ArrayList<Long>();

                int temp = 0; int addrtemp = 0;
                String m  = st.nextToken();
                for(int i = 0; i < m.length(); i++){
                    int c = Character.getNumericValue(m.charAt(i));
                    long v = (long) Math.pow(2,35-i);
                    if(c != 33){
                        temp += v;
                        mask += c * v;
                    }
                    else {
                        addrtemp += v;
                        masks.add(v);
                    }
                }
                ovv = ~temp; addrovv = ~addrtemp;
                masks = permutations(masks);
            }
            else{
                long addr = Long.parseLong(st.nextToken());
                long val = Long.parseLong(st.nextToken());

                valc.put(addr,(val & ovv) | mask);
                for(long i : masks) addrc.put(((addr & addrovv) | i ) | mask, val);
            }
        }

        long sum1 = 0; long sum2 = 0;

        for(long i : valc.keySet()) sum1 += valc.get(i);
        for(long i : addrc.keySet()) sum2 += addrc.get(i);

        System.out.println(sum2);
        System.out.println(sum1);



    }
}
