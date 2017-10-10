import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-10-08.
 */
public class KthString {

    public static void main(String []args)
    {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++)
        {
            int K = sc.nextInt();
            sc.nextLine();

            String line = sc.nextLine();

            int length = line.length();
            ArrayList<String> list = new ArrayList<>();
            String tmp ="";
            for(int i = length-1;i>=0;i--)
            {
                tmp = line.charAt(i)+tmp;
                list.add(tmp);
            }
            list.sort(null);
            if(K >list.size())
                System.out.println("#"+tc+" none");
            else
                System.out.println("#"+tc+" "+list.get(K-1));
        }
    }
}
