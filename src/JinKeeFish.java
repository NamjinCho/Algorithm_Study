import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-06.
 */
public class JinKeeFish {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            boolean f= true;

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int num=0;
            int arr[] = new int[N];

            for(int i=0;i<N;i++)
            {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int time = 0;
            int max = arr[arr.length-1];
            int cur = 0;
            while (time<=max){
                if(time%M==0)
                    num+=K;

                if(arr[cur]==time)
                {
                    cur++;
                    if(num>0)
                    {
                        num--;
                    }else
                    {
                        f = false;
                        break;
                    }
                }
                time++;
            }
                System.out.print("#"+tc+" ");
            if(f)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
    }
}
