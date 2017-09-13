import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-13.
 */
public class BigSubArrDesc {

    public static void main(String []args)
    {
        Scanner sc = new Scanner( System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][2];

        arr[0][0] = sc.nextInt();
        arr[0][1] = arr[0][0];
        int ans = arr[0][0];
        for(int i=1;i<N;i++)
        {
            arr[i][0] = sc.nextInt();
            int max = 0;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j][0] < arr[i][0])
                {
                    max = Math.max(arr[j][1],max);
                }
            }
            arr[i][1] = max + arr[i][0];
            ans = Math.max(arr[i][1],ans);
        }
        System.out.println(ans);
    }
}
