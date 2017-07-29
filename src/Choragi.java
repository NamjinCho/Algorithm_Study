import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-26.
 */
public class Choragi {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();

        int one[][] = new int [2][N];

        for(int i=0;i<2;i++)
        {
            for(int j=0;j<N;j++)
                one[i][j]=sc.nextInt();
        }


    }

}
