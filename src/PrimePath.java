import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-04.
 */
public class PrimePath {
    static boolean[]visit;

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++)
        {
            init();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int ans = bfs(a,b);
            if(ans==-1)
                System.out.println("Impossible");
            else
                System.out.println(ans);
        }
    }
    static int bfs(int s,int e)
    {
        if(s==e)
            return 0;
        Queue<Integer> sq = new LinkedList<>();
        Queue<Integer> cq=new LinkedList<>();
        visit[s] = true;
        sq.offer(s);
        cq.offer(0);
        while (!sq.isEmpty())
        {
            int ss = sq.poll();
            int cc=  cq.poll();

            for(int no=1;no<=4;no++)
            {
                for(int i=0;i<=9;i++)
                {
                    int result = change(ss,no,i);
                    if(!visit[result])
                    {
                        if(result==e)
                            return cc+1;
                        visit[result] = true;
                        sq.offer(result);
                        cq.offer(cc+1);
                    }
                }
            }
        }


        return -1;
    }
    static int change(int s, int no,int i)
    {
            int og = s;
            if (no == 1) {
                if(i==0)
                    return s;

                og = (i*1000)+(s%1000);
            } else if (no == 2) {
                int first = s/1000;
                first*=1000;
                int second  = i;
                second*=100;
                int other = s%100;
                og = first+other+second;
            } else if (no == 3) {

                int first = s/100;
                first*=100;
                int second  = i;
                second*=10;
                int other = s%10;
                og = first+other+second;
            } else if (no == 4) {
                int first = s/10;
                first*=10;
                int other = i;
                og = first+other;
            }

            return og;
    }
    static void init()
    {
        visit=new boolean[10001];
        for(int i=2;i<10001;i++)
        {
            if(!visit[i])
            {
                deletion(i);
            }
        }
    }
    static void deletion(int s)
    {

        for(int i=s+s;i<10001;i=i+s)
        {
            visit[i]=true;
        }
    }
}
