import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class KnightTour {

    public static void main(String[] args)
    {
        int dir[][] = {{-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{-1,2},{1,-2},{1,2}};
        int A = 'A'-1;
        int one = '1'-1;
        int board[][] = new int[7][7];
        Scanner sc = new Scanner(System.in);
        int prow=-1,pcol=-1;
        for(int i=0;i<36;i++)
        {
            String line = sc.nextLine();
            int row = line.charAt(0)-A;
            int col = line.charAt(1)-one;

            if(board[row][col] == 1)
            {
                System.out.println("Invalid");
                return;
            }
            if(prow==-1 && pcol==-1)
            {
                prow = row;
                pcol = col;
                continue;
            }
            boolean f=false;
            for(int j = 0;j<8;j++)
            {
                int nr = prow +dir[j][0];
                int nc = pcol+dir[j][1];
                if(nr>=1 && nr < 7 && nc>=1 && nc<7)
                {
                    if(nr==row && nc == col)
                    {
                        f =true;
                        break;
                    }
                }
            }
            if(f==false)
            {
                System.out.println("Invalid");
                return;
            }
            board[row][col]=1;
            prow=row;
            pcol=col;
        }
        System.out.println("Valid");
    }
}
