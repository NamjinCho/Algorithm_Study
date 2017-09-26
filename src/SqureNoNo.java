import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class SqureNoNo {

    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);

        String input = sc.nextLine();
        String sub[] = input.split(" ");
        BigInteger min,max;
        min = new BigInteger(sub[0]);
        max = new BigInteger(sub[1]);
        HashMap<String,Boolean> visit = new HashMap<>();
        BigInteger one = new BigInteger("1");
        BigInteger ans = max.subtract(min).add(one);
        BigInteger tmp;
        for(BigInteger i = new BigInteger("2");i.multiply(i).compareTo(max)<=0;i=i.add(one))
        {
            for(BigInteger j = new BigInteger("1");true;j=j.add(one))
            {
                tmp = j.multiply(i.multiply(i));
                if(tmp.compareTo(max)>0)
                    break;

                if(!visit.containsKey(tmp.toString()))
                {
                    ans = ans.subtract(one);
                    visit.put(tmp.toString(),true);
                }
            }
        }
        System.out.println(ans.toString());


    }


}
