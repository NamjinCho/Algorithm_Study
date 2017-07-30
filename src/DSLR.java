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
        boolean visit[]=new boolean[20001];
        String [] cmd = new String [20001];
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
                    String s2 = s+"";
                    if(s2.length()<4)
                    {
                        int k = 4-s2.length();
                        for(int j=0;j<k;j++)
                            s2="0"+s2;

                    }
                    String s3 = s2.substring(1,4)+s2.substring(0,1);
                    tmp = Integer.parseInt(s3);
                    t='L';
                }else{
                    String s2 = s+"";
                    if(s2.length()<4)
                    {
                        int k = 4-s2.length();
                        for(int j=0;j<k;j++)
                            s2="0"+s2;

                    }
                    String s3 = s2.substring(3,4)+s2.substring(0,3);
                    tmp = Integer.parseInt(s3);
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
