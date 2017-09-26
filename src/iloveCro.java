import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class iloveCro {
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        int p = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        int N = sc.nextInt();

        for(int i=8;i>0;i--)
            q.offer(i);
        while(q.peek()!=p)
        {
            int t= q.poll();
            q.offer(t);
        }
        sc.nextLine();
        int left = 210;
        for(int i=0;i<N;i++)
        {
            String l = sc.nextLine().trim();

            String sub[] = l.split(" ");
            int al = Integer.parseInt(sub[0]);
            if(left-al >0 )
            {
                left = left-al;

                if(sub[1].equals("T"))
                {
                    int t = q.poll();
                    q.offer(t);
                }

            }else
            {
                break;
            }
        }
        System.out.println(q.peek());

    }
}
