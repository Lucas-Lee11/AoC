import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

public class Day11{

    static int[] XY = {-1,1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day11.txt"));
        String line;
        List<String> list = new ArrayList<String>();
        List<String> listc = new ArrayList<String>();

        while((line = br.readLine()) != null) list.add(line);

        int nrow = list.size();
        int ncol = list.get(0).length();

        boolean changed = false;
        do{
            changed = false;
            for(int i = 0; i < nrow; i++) {
                String newRow = "";
                for(int j = 0; j < ncol; j++){
                    char c = list.get(i).charAt(j);
                    int occ = 0;
                    if(c != '.')for(int dx : XY) for(int dy : XY) if(!(dx == 0 && dy == 0)){
                        try{
                            int x = j; int y = i; char n = '.';
                            while(n == '.') {
                                x += dx; y += dy;
                                n = list.get(y).charAt(x);
                            }
                            if(n == '#') occ++;
                        } catch(Exception e){}
                    }
                    if(occ == 0 && c == 'L') {
                        newRow += '#';
                        changed = true;
                    }
                    else if(occ >= 5 && c == '#') {
                        newRow += 'L';
                        changed = true;
                    }
                    else newRow += c;
                }
                listc.add(i,newRow);
            }
            list = listc;
            listc = new ArrayList<String>();
        }while(changed);

        int occ = 0;
        for(String r : list) for(int i = 0; i < ncol; i++) if(r.charAt(i) == '#') occ++;
        System.out.println(occ);


    }
}
