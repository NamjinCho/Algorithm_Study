import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-19.
 */

public class ChessKing {

    public static void main(String [] args)
    {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String [] subLine = line.split(" ");
        int kr = Integer.parseInt(subLine[0].charAt(1)+"");
        int kc = subLine[0].charAt(0)-64;
        int sr = Integer.parseInt(subLine[1].charAt(1)+"");
        int sc = subLine[1].charAt(0)-64;
        int n = Integer.parseInt(subLine[2]);
        int dir[][] ={{0,1},{0,-1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i=0;i<n;i++)
        {
            int idx = -1;
            String move = in.nextLine();
            if(move.equals("R"))
                idx= 0;
            else if(move.equals("L"))
                idx=1;
            else if(move.equals("B"))
                idx=2;
            else if(move.equals("T"))
                idx=3;
            else if(move.equals("RT"))
                idx=4;
            else if(move.equals("LT"))
                idx=5;
            else if(move.equals("RB"))
                idx=6;
            else
                idx=7;
            int newRow = kr+dir[idx][0];
            int newCol = kc+dir[idx][1];
            if(newRow<1 || newRow >8 || newCol <1 ||newCol>8)
                continue;
            if(newRow==sr && newCol==sc)
            {
                int sRow = sr+dir[idx][0];
                int sCol = sc+dir[idx][1];
                if(sRow<1 || sRow >8 || sCol <1 ||sCol>8)
                    continue;
                else
                {
                    sr=sRow;
                    sc=sCol;
                }
            }
            kr=newRow;
            kc=newCol;
        }
        System.out.println((char)(kc+64)+""+kr);
        System.out.println((char)(sc+64)+""+sr);

    }
}
