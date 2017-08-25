import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class IncresingArray {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        int size[] = new int[N];

        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        size[0] = 1;
        int max = 1;
        for(int i=1;i<N;i++)
        {
            int tmax = 0;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j] <arr[i])
                    tmax = Math.max(tmax,size[j]);
            }
            size[i] = tmax + 1;
            max = Math.max(size[i],max);
        }
        System.out.println(max);
    }
}
