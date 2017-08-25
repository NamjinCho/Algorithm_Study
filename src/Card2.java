import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class Card2 {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1;i<=N;i++)
        {
            list.addLast(i);
        }
        while(list.size()!=1)
        {
            list.removeFirst();
            int f = list.getFirst();
            list.removeFirst();
            list.addLast(f);
        }
        System.out.println(list.getFirst());
    }
}
