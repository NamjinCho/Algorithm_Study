import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-08.
 */
public class Chocolate {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = (N-1) + (M-1)*(N);
        System.out.println(ans);
    }
}
