import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-27.
 */
public class CMD {
    public static void main(String [] args)
    {
        Scanner sc =new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String [] lines = new String[N];
        for(int i=0;i<N;i++)
            lines[i] = sc.nextLine().trim();

        String result = "";
        int length = lines[0].length();

        for(int i=0;i<length;i++)
        {
            boolean flag = true;
            char s = lines[0].charAt(i);
            for(int j=1;j<N;j++)
            {
                if(lines[j].charAt(i)!=s)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                result=result+s;
            else
                result = result+"?";
        }
        System.out.println(result);
    }
}
