import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class BOJ1551 {




    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        int N =sc.nextInt();
        int arr[] = new int[N];


        int K  = sc.nextInt();

        sc.nextLine();
        String line = sc.nextLine();

        String [] sub = line.split(",");

        for(int i=0;i<sub.length;i++)
            arr[i] = Integer.parseInt(sub[i]);

        for(int i=0;i<K;i++)
        {
            for(int j=0;j<N-i-1;j++)
            {
                arr[j]= arr[j+1]-arr[j];
            }
        }
        for(int i=0;i<N-K;i++)
        {
            System.out.print(arr[i]);
            if(i!=N-K-1)
                System.out.print(",");
        }
        System.out.println();
    }
}
