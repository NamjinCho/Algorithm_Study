import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-13.
 */
public class ChessRePainting {
    public static void main(String []args)
    {

        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char map [][] = new char[N][M];

        for(int i=0;i<N;i++)
        {
            String line =sc.nextLine();
            for(int j=0;j<M;j++)
            {
                map[i][j] = line.charAt(j);
            }
        }
    }
    public static int solve(int row , int col)
    {
        return 0;
    }
}
