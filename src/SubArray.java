import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class SubArray {


    static int [] arr;
    static int N,S;
    static int minSize;
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 0; tc<T;tc++)
        {
            N = sc.nextInt();
            S = sc.nextInt();
            arr = new int [N];

            for(int i=0;i<N;i++)
            {
                arr[i] = sc.nextInt();
            }
            minSize = Integer.MAX_VALUE;
            divide(0,N-1);
            if(minSize==Integer.MAX_VALUE)
                minSize=0;
            System.out.println(minSize);
        }
    }
    public static int divide(int l,int r)
    {

        if(l==r)
            return arr[l];

        int mid = (l+r)/2;
        int left = divide(l,mid);
        int right = divide(mid+1,r);
        System.out.println(l + " / " + mid + " / " + r + " : " +left + " - " + right);
        if(left>=S)
        {
            minSize = Math.min(minSize,mid-l);
        }
        if(right>=S)
        {
            minSize = Math.min(minSize,r-mid);
        }

        int result = left + right;
        if(result>=S)
        {
            minSize = Math.min(minSize,r-l);
        }
        return result;
    }
}
