import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-07.
 */
public class Ball {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int ptr = 1;

        for(int i=0;i<M;i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if(s==ptr)
            {
                ptr = e;
            }else if(e == ptr)
            {
                ptr = s;
            }
        }
        System.out.println(ptr);

    }


}
