import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-21.
 */
public class Truck {
    public static void main(String []args)
    {

        Scanner sc= new Scanner(System.in);
        int N,W,L;

        N = sc.nextInt();
        W = sc.nextInt();
        L = sc.nextInt();

        int arr[] = new int[N];

        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();

        int ans = 0;
        boolean check[] = new boolean[N];
        int wait = 0;
        int total = L;
        int time[] = new int[N];
        for(int i=0;i<N;i++)
            time[i] = W;
        ArrayList<Integer> wQ = new ArrayList<>();
        while (wait<N)
        {
            if(time[wait]==W)
            {
                if(total-arr[wait] >=0) {
                    total = total - arr[wait];
                    wQ.add(wait);
                    wait++;
                }
            }
            for(int i=0;i<wQ.size();i++)
            {
                int idx = wQ.get(i);
                time[idx]--;
                if(time[idx]==0)
                {
                    wQ.remove(0);
                    i--;
                    total = total+arr[idx];
                }
            }

            ans++;
        }
        while(time[wait-1]>0)
        {
            time[wait-1]--;
            ans++;
        }
        System.out.println(ans+1);

    }

}
