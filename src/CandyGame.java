import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-28.
 */
public class CandyGame {
    static char [][] map;
    public static void main(String []args)
    {
        int ans =0;
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        map = new char[N][N];

        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            for(int j=0;j<N;j++)
            {
                map[i][j] = line.charAt(j);
            }
        }
        int t=0,tt=0;
        while (t<N)
        {
            ans = Math.max(longSeq(t,tt),ans);
            t++;
            tt++;
        }

        int dir[][] = {{0,1},{1,0}};

        for(int r=0;r<N;r++)
        {
            for(int c =0; c<N;c++)
            {
                for(int i=0;i<2;i++)
                {
                    int nr = r+dir[i][0];
                    int nc = c+dir[i][1];

                    if(nr<N && nc<N)
                    {
                        swap(r,c,nr,nc);
                        //로직
                        ans = Math.max(ans,longSeq(r,c));
                        ans = Math.max(ans,longSeq(nr,nc));
                        swap(r,c,nr,nc);
                    }

                }
            }
        }
        System.out.println(ans);
    }
    public static int longSeq(int r,int c)
    {
        int ans = 1;
        char start = map[0][c];
        int count =1 ;
        for(int i=1;i<map.length;i++)
        {
            if(start==map[i][c])
            {
                count++;
            }else
            {
                ans = Math.max(ans,count);
                count = 1;
                start= map[i][c];
            }
        }
        ans  =Math.max(count,ans);
        start = map[r][0];
        count = 1;
        for(int i=1;i<map.length;i++)
        {
            if(start==map[r][i])
            {
                count++;
            }else
            {
                ans = Math.max(ans,count);
                count = 1;
                start= map[r][i];
            }
        }
        ans = Math.max(count,ans);
        return ans;
    }
    public static void swap(int r1,int c1,int r2,int c2)
    {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }
}
