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
            int defaults [] = new int [ 4];
            defaults[1] = 1;
            defaults[2] = 2;
            defaults[3] = 4;
            if (N <= 3) {
                System.out.println(defaults[N]);
            }else
            {
                int arr[] = new int[N+1];
                arr[1] = 1;
                arr[2] = 2;
                arr[3] = 4;
                for(int i=4;i<=N;i++)
                    arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
                System.out.println(arr[N]);
            }
        }
    }
}
