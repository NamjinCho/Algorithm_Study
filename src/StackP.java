import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NamjinCho on 2017-09-17.
 */
public class StackP {
    public static void main(String []args)
    {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++)
        {
            String line = sc.nextLine();
            if(line.startsWith("push"))
            {
                int x = Integer.parseInt(line.split(" ")[1]);
                stack.push(x);
            }else if(line.startsWith("pop"))
            {
                int t= -1;
                if(!stack.isEmpty())
                    t = stack.pop();
                System.out.println(t);
            }else if(line.startsWith("size"))
                System.out.println(stack.size());
            else if(line.startsWith("empty"))
            {
                if(stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }else
            {
                int t= -1;
                if(!stack.isEmpty())
                    t = stack.peek();
                System.out.println(t);
            }
        }
    }
}
