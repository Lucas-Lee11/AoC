import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Day4{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day4.txt"));
        StringTokenizer st;
        String line = br.readLine();
        int count = 0;

        while(line != null){
            HashMap<String,String> list = new HashMap<String,String>();

            while(line != null && !"".equals(line)) {
                st = new StringTokenizer(line, " :");

                while(st.hasMoreTokens()) list.put(st.nextToken(), st.nextToken());

                line = br.readLine();
             }

             if(list.containsKey("byr") && list.containsKey("iyr") && list.containsKey("eyr") && list.containsKey("hgt") && list.containsKey("hcl") && list.containsKey("ecl") && list.containsKey("pid")){
                 boolean a = Integer.parseInt(list.get("byr")) >= 1920 && Integer.parseInt(list.get("byr")) <= 2002;
                 boolean b = Integer.parseInt(list.get("iyr")) >= 2010 && Integer.parseInt(list.get("iyr")) <= 2020;
                 boolean c = Integer.parseInt(list.get("eyr")) >= 2020 && Integer.parseInt(list.get("eyr")) <= 2030;

                 String hgt = list.get("hgt");
                 boolean d = false;
                 if("cm".equals(hgt.substring(hgt.length() - 2, hgt.length()))){
                     int s = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
                     if(s >= 150 && s <= 193) d = true;
                 }
                 else if ("in".equals(hgt.substring(hgt.length() - 2, hgt.length()))){
                     int s = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
                     if(s >= 59 && s <= 76) d = true;
                 }

                 String hcl = list.get("hcl");
                 boolean e = false;
                 if(hcl.charAt(0) == '#' && hcl.length()-1 == 6){
                     boolean flag = true;
                     for(int i = 1; i < hcl.length() && e; i++) {
                         char l = hcl.charAt(i);
                         flag = flag && ((l >= '0' && l <= '9') || (l >= 'a' && l <= 'f'));
                     }
                     e = flag;
                 }

                 String ecl = list.get("ecl");
                 boolean f = "amb".equals(ecl) || "blu".equals(ecl) || "brn".equals(ecl) || "gry".equals(ecl) || "grn".equals(ecl) || "hzl".equals(ecl) || "oth".equals(ecl);

                 int pid;
                 boolean g = list.get("pid").length() == 9;
                 try{
                     pid = Integer.parseInt(list.get("pid"));
                 }catch(Exception ex){
                     g = false;
                 }

                 if(f)System.out.println("A\t" + list.get("ecl"));
                 else System.out.println("D\t" + list.get("ecl"));


                 if(a && b && c && d && e && f && g) {
                     count++;
                     for (Map.Entry<String,String> entry : list.entrySet()) {
                         System.out.println(entry.getKey()+" : "+entry.getValue());
                     }
                     System.out.print("\n");
                 }

             }

             line = br.readLine();
         }

         System.out.println(count);


     }

}
