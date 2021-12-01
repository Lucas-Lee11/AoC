import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.math.BigInteger;


public class Day13{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day13.txt"));
        Map<Long,Long> list = new HashMap<Long,Long>();

        long n = 0; long div = 1; long find = 0;
        long t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        while(st.hasMoreTokens()){
            String s = st.nextToken();
            if(!"x".equals(s)){
                long a = Integer.parseInt(s);
                if(n != 0){
                    list.put(a,a-n);
                    div *= a;
                }
                else {
                    list.put(a,(long)0);
                    find = a;
                }
            }
            n++;
        }


        long s = t;
        long id = 0;
        while(id == 0){
            t++;
            for(long i: list.keySet()) if(t % i == 0) id = i;
        }
        System.out.println((t-s)*id);

        long mod = (long) 0;
        for(long i :list.keySet()){
            long a = list.get(i);
            if(a == 0) continue;
            long y = (div / i);
            long z = BigInteger.valueOf(y).modInverse(BigInteger.valueOf(i)).longValue();
            mod += a*y*z;
        }

        long m = mod % div;
        long i = div;
        while((i+m) % find != 0) i += div;
        System.out.println(i + m);


    }
}
