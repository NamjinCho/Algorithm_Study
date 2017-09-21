import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-20.
 */
public class Suceeding {

    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);

        HashMap<String, Double> map = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();
        String first = sc.nextLine();

        map.put(first,1.00);

        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            String sub[] = line.split(" ");
            double total = 0;
            for(int j=1;j<=2;j++)
            {
                if(map.containsKey(sub[j]))
                {
                    total +=map.get(sub[j]);
                }else
                {
                    map.put(sub[j],0.00);
                }
            }
            total = total/2;

            map.put(sub[0],total);
        }
        String maxName=sc.nextLine();
        double max = 0;
        if(map.containsKey(maxName))
            max = map.get(maxName);
        for(int i=1;i<M;i++)
        {
            String line = sc.nextLine();
            System.out.println(map.get(line) + " " + line);
            if(map.containsKey(line))
            {
                if(max<map.get(line))
                {
                    max = map.get(line);
                    maxName = line;
                }
            }
        }
        System.out.println(maxName + " " + max);




    }
}
