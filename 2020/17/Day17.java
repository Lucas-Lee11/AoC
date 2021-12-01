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

public class Day17{

    static int size = 32;
    static int[] XYZW = {-1,0,1};

    private static boolean[][][][] swap(boolean[][][][] arr){
        boolean[][][][] temp = new boolean[size][size][size][size];
        for(int w = 0; w < size; w++)for(int z = 0; z < size; z++) for(int y = 0; y < size; y++) for(int x = 0; x < size; x++){
            int act = 0;
            for(int dw : XYZW)for(int dz : XYZW) for(int dy : XYZW) for(int dx : XYZW){
                try{
                    if(!(dw == 0 && dz == 0 && dy == 0 && dx == 0) && arr[w+dw][z+dz][y+dy][x+dx]) act++;
                } catch(IndexOutOfBoundsException e){}
            }
            if (arr[w][z][y][x] && (act == 2 || act == 3)) temp[w][z][y][x] = true;
            else if (!arr[w][z][y][x] && act == 3) temp[w][z][y][x] = true;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./Day17.txt"));
        String line;

        boolean[][][][] arr = new boolean[size][size][size][size];
        int row = 0; int l = 0;
        while((line = br.readLine()) != null){
            l = line.length();
            for(int i = 0; i < line.length(); i++) if(line.charAt(i) == '#') arr[size/2][size/2][size/2 + row][size/2 + i] = true;
            row++;
        }

        for(int i = 0; i < 6; i++) arr = swap(arr);

        int sum = 0;
        for(int w = 0; w < size; w++)for(int z = 0; z < size; z++) for(int y = 0; y < size; y++) for(int x = 0; x < size; x++) if(arr[w][z][y][x]) sum++;
        System.out.println(sum);



    }
}
