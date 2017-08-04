import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-29.
 */
public class DSLR {


    public static void main(String [ ] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++)
        {
            int og = sc.nextInt();
            int dst = sc.nextInt();
            System.out.println(bfs(og,dst));
        }
    }
    public static String bfs(int og, int dst)
    {
        boolean visit[]=new boolean[10001];
        String [] cmd = new String [10001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(og);
        visit[og]=true;
        if(og==dst)
            return "";

        while (!q.isEmpty())
        {
            int s = q.poll();
            if(cmd[s]==null)
                cmd[s]="";

            for(int i=0;i<4;i++)
            {
                char t;

                int tmp;
                if(i==0)
                {
                    t='D';
                    tmp = (s*2) %10000;


                }else if(i==1)
                {

                    tmp = s-1;
                    if(s==0)
                        tmp=9999;

                    t='S';
                }else if(i==2)
                {

                    int first = s / 1000;
                    int last = s % 1000;
                    tmp = (last)*10 + first;
                    t='L';
                }else{
                    int last = s%10;
                    tmp =  s/10 + last*1000;
                    t='R';
                }

                if(tmp>=0 && tmp < 20000 &&!visit[tmp])
                {
                    cmd[tmp]=cmd[s]+t;
                    if(tmp==dst)
                        return cmd[tmp];
                    visit[tmp]=true;
                    q.offer(tmp);
                }
            }
        }
        return "";
    }
}
