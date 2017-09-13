import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamjinCho on 2017-09-13.
 */
public class SquareProblem {
    static ArrayList<Integer> list;
    static int arr[];
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int [N+1];

        if(N<=3)
        {
            System.out.println(N);
        }else
        {


            int count=0;
            arr[2] = 2;
            arr[3] = 3;
            for(int i=1;i*i<=N;i++)
            {
                arr[i*i] = 1;
            }

            for(int i=1;i<=N;i++)
            {
                for(int j=1;j*j <= i;j++)
                {
                    if(arr[i]!=0 && arr[i]>=arr[i-j*j]+1)
                    {
                       arr[i] = arr[i-j*j] +1;
                    }else if(arr[i]==0)
                    {
                        arr[i] = arr[i-j*j] +1;
                    }

                }
            }

            System.out.println(arr[N]);
        }
    }
}
