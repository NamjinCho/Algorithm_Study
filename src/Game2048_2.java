import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-12.
 */
public class Game2048_2 {

    //조합 만들기 11111
    //4^5 = 1024;
    static int N;
    static int map[][];
    static int ans;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map= new int[N][N];


        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        ans = 0;
        dfs(0,map);
        System.out.println(ans);
    }
    public static void dfs(int count,int board[][])
    {
        if(count >= 5)
        {
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    ans = Math.max(ans,board[i][j]);
            }
            return;
        }
        //RDLU
        int condition[] = new int[3];
        int nBoard[][] = copy(board);
        condition[0] = N-1;
        condition[1] = -1;
        condition[2] = -1;
        push(0,condition,nBoard);
        dfs(count+1,nBoard);

        nBoard= copy(board);
        condition[0] = N-1;
        condition[1] = -1;
        condition[2] = -1;
        push(1,condition,nBoard);
        dfs(count+1,nBoard);

        nBoard = copy(board);
        condition[0] = 0;
        condition[1] = N;
        condition[2] = 1;
        push(2,condition,nBoard);
        dfs(count+1,nBoard);

        nBoard = copy(board);
        condition[0] = 0;
        condition[1] = N;
        condition[2] = 1;
        push(3,condition,nBoard);
        dfs(count+1,nBoard);

    }
    public static int[][] copy(int [][] board)
    {
        int [][] result = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }
    public static void push(int didx,int []condition,int [][]board)
    {
        boolean[][] check = new boolean[N][N];
        for(int i = condition[0]; i!=condition[1];i=i+condition[2])
        {
            for(int j = condition[0]; j!=condition[1];j=j+condition[2])
            {
                if(board[i][j]==0)
                    continue;

                int nr=i+dir[didx][0];
                int nc=j+dir[didx][1];
                int tr=i;
                int tc=j;
                while (nr >= 0 && nr<N && nc>=0 && nc< N) {
                   if (board[nr][nc] != 0 && !check[nr][nc]){
                        if(board[nr][nc]==board[tr][tc])
                        {
                            board[nr][nc] = board[nr][nc]+board[nr][nc];
                            board[tr][tc] = 0;
                            check[nr][nc] = true;
                            break;
                        }else
                        {
                            break;
                        }
                    }else if(!check[nr][nc])
                    {
                        board[nr][nc] = board[tr][tc];
                        board[tr][tc] = 0;
                    }else
                        break;
                    tr = nr;
                    tc = nc;
                    nr=tr+dir[didx][0];
                    nc=tc+dir[didx][1];
                }

            }
        }

    }

}
