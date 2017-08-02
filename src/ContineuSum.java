import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-02.
 */
public class ContineuSum {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int [N][2];
        int Max=0;

        for(int i=0;i<N;i++)
        {
            arr[i][0]=sc.nextInt();
            if(i==0)
            {
                arr[0][1] = arr[0][0];
                Max = arr[0][0];
                continue;
            }
            arr[i][1] = Math.max(arr[i-1][0],arr[i-1][1]) + arr[i][0];
            Max = Math.max(arr[i][0],Max);
            Max = Math.max(arr[i][1],Max);
        }
        System.out.println(Max);



    }


}
