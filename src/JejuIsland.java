import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-11.
 */
public class JejuIsland {

    static int N;
    static int M;
    static int MAXTIME = (60*9);
    static class Spot{
        boolean isHotel;
        int [] adj;
        int spendedTime;
        int point;
    }
    static Spot spots[];
    static boolean visit[];
    static int ans = 0;
    static int start;
    static String list_spot;
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            N = sc.nextInt();
            M =sc.nextInt();
            visit = new boolean[N];
            spots = new Spot[N];

            for(int i=0;i<N;i++)
            {
                spots[i] = new Spot();
                spots[i].adj = new int[N];
            }
            for(int i=0;i<N-1;i++)
            {
                for(int j=i+1;j<N;j++)
                {
                    int t = sc.nextInt();
                    spots[i].adj[j] = t;
                    spots[j].adj[i] = t;
                }
            }
            sc.nextLine();
            for(int i=0;i<N;i++)
            {
                String line = sc.nextLine();
                if(line.startsWith("A"))
                    start = i;
                else if(line.startsWith("P"))
                {
                    String sub[] = line.split(" ");
                    spots[i].spendedTime  = Integer.parseInt(sub[1]);
                    spots[i].point = Integer.parseInt(sub[2]);
                }else
                {
                    spots[i].isHotel = true;
                }
            }

            list_spot="";
            dfs(start,1,0,0,"");
            System.out.println("#"+tc+" "+ans+" "+list_spot);
        }
    }
    public static void dfs(int current,int m,int time,int point,String list)
    {
        if(m > M)
        {
            if(ans < point)
            {
                ans = point;
                list_spot = list;
            }
            return;
        }
        for(int i=0;i<N;i++)
        {
            if(i==current)
                continue;
            if(m!=M && i==start)
                continue;

            if(!visit[i] || spots[i].isHotel)
            {
                if(spots[i].isHotel)
                {
                    if(m==M)
                        continue;

                    int tmp = spots[current].adj[i] + time;
                    if(tmp<=MAXTIME)
                    {
                        dfs(i,m+1,0,point,(list+(i+1)+" "));
                    }
                }else
                {
                    int tmp = spots[current].adj[i] + spots[i].spendedTime + time;

                    if(tmp<=MAXTIME)
                    {
                        visit[i] = true;
                        int w = 0;

                        if(m==M && i == start)
                            w = 1;

                        dfs(i,m+w,tmp,point+spots[i].point,(list+(i+1)+" "));
                        visit[i] = false;

                    }
                }
            }
        }
    }
}
