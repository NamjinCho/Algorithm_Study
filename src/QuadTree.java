import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-28.
 */
public class QuadTree {


    static int N;
    static int board[][];
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        board = new int[N][N];

        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<N;j++)
            {
                board[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }
        String r = divde(0,N,0,N);
        System.out.println(r);
    }
    public static String divde(int rs , int rl , int cs , int cl)
    {
        int r = check(rs,rl,cs,cl);
        if(r>=0)
            return r+"";

        String []result = new String [4];
        // 1 분 면 rs = rs , rl = rs+rl/2 , cs = cs , cl = cl+cs/2
        result[0] = divde(rs,(rl+rs)/2,cs,(cl+cs)/2);
        // 2 분 면 rs = rs , rl = rs+rl/2 , cs = cs+cl/2 , cl = cl
        result[1] = divde(rs,(rl+rs)/2,(cl+cs)/2,cl);
        // 3 분면  rs = rs+rl/2 , rl = rl , cs = cs , cl = cl+cs/2
        result[2] = divde((rl+rs)/2,rl,cs,(cl+cs)/2);
        // 4 분면 rs = rs+rl/2 , rl = rl , cs = cs+cl/2 , cl = cl
        result[3] = divde((rl+rs)/2,rl,(cl+cs)/2,cl);

        String total ="(";
        for(int i = 0 ; i<4;i++)
            total=total+result[i];
        return total+")";
    }

    public static int check(int rs, int rl , int cs ,int cl)
    {
        int start = board[rs][cs];
        for(int i=rs;i<rl;i++)
        {
            for(int j = cs;j<cl;j++)
            {
                if(board[i][j]!=start)
                    return -1;
            }
        }
        return start;
    }


}
