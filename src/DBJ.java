import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-26.
 */
public class DBJ {
    public static void main(String []args)
    {
        int x=-3*5%5+1;
        System.out.println(x);


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M =sc.nextInt();
        sc.nextLine();

        HashMap<String,Boolean> map = new HashMap<String, Boolean>();

        for(int i=0;i<N;i++)
            map.put(sc.nextLine(),true);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<M;i++)
        {
            String line = sc.nextLine();
            if(map.containsKey(line))
            {
                ans.add(line);
            }
        }
        System.out.println(ans.size());
        ans.sort(null);

        for(int i=0;i<ans.size();i++)
            System.out.println(ans.get(i));


    }
}
