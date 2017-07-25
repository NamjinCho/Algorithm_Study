import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-25.
 */
public class PCycle {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0; tc<T;tc++)
        {
            int N = sc.nextInt();
            int [] arr = new int[N+1];
            boolean []visit = new boolean[N+1];

            for(int i=1;i<=N;i++)
            {
                arr[i]=sc.nextInt();
            }
            int count = 0;
            for(int i=1;i<=N;i++)
            {
                int next = arr[i];
                visit[i] = true;
                while (true)
                {
                    if(!visit[next])
                    {
                        visit[next]=true;
                    }else
                    {
                        if(next==i)
                        {
                            count++;
                            break;
                        }else
                            break;
                    }
                    next=arr[next];
                }
            }
            System.out.println(count);
        }

    }
}
