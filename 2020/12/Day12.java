import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class Day12{

    public static void main(String[] args) {
        In in = new In("./Day12.txt");

        int wx = 10; int wy = 1;
        int x = 0; int y = 0;
        while(!in.isEmpty()){
            char d = in.readChar();
            int u = in.readInt();

            if(d == 'F'){
                x += u * wx;
                y += u * wy;
            }
            else if(d == 'R'){
                int temp = wx;
                wx = wx * (int) Math.cos(-Math.toRadians(u)) - wy * (int) Math.sin(-Math.toRadians(u));
                wy = wy * (int) Math.cos(-Math.toRadians(u)) + temp * (int) Math.sin(-Math.toRadians(u));
            }
            else if(d == 'L'){
                int temp = wx;
                wx = wx * (int) Math.cos(Math.toRadians(u)) - wy * (int) Math.sin(Math.toRadians(u));
                wy = wy * (int) Math.cos(Math.toRadians(u)) + temp * (int) Math.sin(Math.toRadians(u));
            }
            else if(d == 'N') wy += u;
            else if(d == 'S') wy -= u;
            else if(d == 'W') wx -= u;
            else if(d == 'E') wx += u;
            StdOut.println(d +""+ u + "\t" + x + ","+ y + "\t" + wx + "," + wy);

            in.readChar();
        }

        x = Math.abs(x); y = Math.abs(y);
        StdOut.println(x+y);

    }
}
