import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-21.
 */
public class Dice {

    public static void main(String [] args)
    {

        int dice[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int row = sc.nextInt();
        int col = sc.nextInt();
        int K = sc.nextInt();

        int map[][] = new int[N][M];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++) {
                int t = sc.nextInt();
                map[i][j]=t;
            }
        }

        int dir[][] = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; //동서북남 오외위아0 1234
        for(int i =0;i<K;i++)
        {
            int idc = sc.nextInt();
            int nRow = row+dir[idc][0];
            int nCol = col+dir[idc][1];

            if((nRow>=0 && nRow<N) &&(nCol >=0 && nCol<N))
            {

                int tmp[] = new int[4];
                //동서
                if(idc<3)
                {
                    int w = 0;
                    if(idc==1) {
                        w= 1;
                    }else
                        w= -1;
                    for (int k = 0; k<4; k++) {
                        int t = k+w;
                        if(t == -1)
                            t=3;
                        t=t%4;
                        tmp[t]=dice[1][k];
                    }
                    for(int k=0;k<4;k++)
                        dice[1][k] = tmp[k];
                    dice[3][1] = dice [1][3];
                }else//북 남
                {
                    int w = 0;
                    if(idc==3) {
                        w =-1;
                    }else
                        w= 1;
                    for (int k = 0; k<4; k++) {
                        int t = k+w;
                        if(t == -1)
                            t=3;
                        t=t%4;
                        tmp[t]=dice[k][1];
                    }

                    for(int k=0;k<4;k++)
                        dice[k][1] = tmp[k];
                    dice[1][3]=dice[3][1];
                }

                System.out.println(dice[1][1]);

                if(map[nRow][nCol]==0)
                {
                    map[nRow][nCol] = dice[1][3];
                }else
                {
                    dice[1][3] = map[nRow][nCol];
                    dice[3][1] = map[nRow][nCol];
                    map[nRow][nCol] = 0;
                }

                row = nRow;
                col= nCol;
            }

        }

    }
}
