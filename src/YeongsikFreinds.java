import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-07.
 */
public class YeongsikFreinds {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N,M,L;
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        int ptr =1,count=0 ;
        int arr[] = new int[N+1];
        while (true)
        {
            arr[ptr]++;
            if(arr[ptr]==M)
                break;
            if(arr[ptr]%2 == 0)
            {
                ptr = ptr-L;
                if(ptr<1)
                {
                    ptr = N + ptr;
                }
            }else{
                ptr+=L;
                if(ptr>N)
                {
                    ptr = ptr-N;
                }
            }
            count++;
        }
        System.out.println(count);

    }
}
