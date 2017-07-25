import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-22.
 */
public class XeroGame {


    static int N;
    static int M;
    static char [][] board;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static int min = Integer.MAX_VALUE;
    public static void main(String [] args)
    {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String sL[] = line.split(" ");

        N = Integer.parseInt(sL[0]);
        M = Integer.parseInt(sL[1]);

        board = new char[N][M];
        int rR=0;
        int rC=0;
        int bR=0;
        int bC=0;
        for(int i=0;i<N;i++)
        {
            line = sc.nextLine();
            for(int j=0;j<M;j++)
            {
                board[i][j] = line.charAt(j);
                if(board[i][j]=='R')
                {
                    rR=i;
                    rC=j;
                }
                else if(board[i][j]=='B')
                {
                    bR=i;
                    bC=j;
                }
            }
        }
        board[rR][rC] ='.';
        board[bR][bC]='.';
        dfs(rR,rC,bR,bC,1);
        if(min==Integer.MAX_VALUE)
            min=-1;
        System.out.println(min);
    }
    public static void dfs(int rRow,int rCol,int bRow,int bCol , int count)
    {
        if(count>=11)
            return;


        for(int i=0;i<4;i++)
        {
            boolean flag=true;
            int nrr=rRow;
            int nrc=rCol;
            int nbr=bRow;
            int nbc=bCol;
            boolean rO = false;
            boolean bO = false;
            boolean first = true;
            if(i==0)
            {
                if(nbr==nrr && nbc>nrc)
                    first=false;
            }else if(i==1)
            {
                if(nbr>nrr && nbc==nrc)
                    first=false;
            }else if(i==2)
            {
                if(nbr==nrr && nbc<nrc)
                    first=false;
            }else
            {
                if(nbr<nrr && nbc==nrc)
                    first=false;
            }
            while(flag)
            {

                flag = false;
                nrr+=dir[i][0];
                nrc+=dir[i][1];
                nbr+=dir[i][0];
                nbc+=dir[i][1];
                if(first) {
                    if(!rO) {
                        if ((board[nrr][nrc] == '.' || board[nrr][nrc] == 'O') && checker(nrr, nrc, nbr, nbc, i)) {
                            flag = true;
                            if (board[nrr][nrc] == 'O')
                                rO = true;
                        } else {
                            nrr -= dir[i][0];
                            nrc -= dir[i][1];
                        }
                        if ((board[nbr][nbc] == '.' || board[nbr][nbc] == 'O') && checker(nrr, nrc, nbr, nbc, i)) {
                            flag = true;
                            // System.out.println("de");
                            if (board[nbr][nbc] == 'O') {
                                bO = true;
                                break;
                            }
                        } else {
                            nbr -= dir[i][0];
                            nbc -= dir[i][1];
                        }
                    }else
                    {
                        nrr=-1;
                        nrc=-1;
                    }
                }else
                {
                    if ((board[nbr][nbc] == '.' || board[nbr][nbc] == 'O') && checker(nrr,nrc,nbr,nbc,i)) {
                        flag = true;
                        //System.out.println("de");
                        if (board[nbr][nbc] == 'O') {
                            bO = true;
                            break;
                        }
                    } else {
                        nbr -= dir[i][0];
                        nbc -= dir[i][1];
                    }
                    if ((board[nrr][nrc] == '.' || board[nrr][nrc] == 'O') && checker(nrr,nrc,nbr,nbc,i)) {
                        flag = true;
                        if (board[nrr][nrc] == 'O')
                            rO = true;
                    } else {
                        nrr -= dir[i][0];
                        nrc -= dir[i][1];
                    }
                }
            }
            if(rO&&!bO)
            {
                min=Math.min(min,count);
                return;
            }
            else if(bO)
            {
                continue;
            }else
            {
                if(nrr!=rRow || nrc!=rCol || nbr!=bRow || nbc!=bCol)
                    dfs(nrr,nrc,nbr,nbc,count+1);
            }
        }
    }
    static boolean checker( int rr,int rc,int br,int bc , int i)
    {
        // 우 하 좌 상

        if((i==0||i==2) && rr==br)
        {
            if(rc==bc)
                return false;
        }else if((i==1 || i== 3)&& rc==bc)
        {
            if(br==rr)
                return false;
        }
        return true;

    }
}
