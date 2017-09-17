import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-14.
 */
public class PutBox {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][2];
        arr[0][0] = sc.nextInt();
        arr[0][1] = 1;
        int ans = arr[0][1];
        for(int i=1;i<N;i++)
        {
            arr[i][0] = sc.nextInt();
            int max = 0;
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i][0] > arr[j][0])
                    max = Math.max(max,arr[j][1]);
            }
            arr[i][1] = max+1;
            ans = Math.max(arr[i][1],ans);
        }
        System.out.println(ans);
    }
}
