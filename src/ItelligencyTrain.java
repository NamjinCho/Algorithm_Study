import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-17.
 */
public class ItelligencyTrain {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int cur = 0;
        int ans = 0;
        for(int i=0;i<4;i++)
        {
            int down = sc.nextInt();
            int up  =sc.nextInt();

            cur = cur - down;
            cur = cur + up;
            if(cur >10000)
                cur = 10000;
            ans = Math.max(ans,cur);
        }
        System.out.println(ans);
    }
}
