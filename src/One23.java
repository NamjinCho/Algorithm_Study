import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class One23 {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =0 ; tc<T;tc++) {
            int N = sc.nextInt ();
            if (N <= 2) {
                System.out.println(N);
            }else
            {
                int arr[] = new int[N+1];
                arr[1] = 1;
                arr[2] = 2;
                for(int i=3;i<=N;i++)
                    arr[i] = arr[i-1]*2 -1;
                System.out.println(arr[N]);
            }
        }
    }
}
