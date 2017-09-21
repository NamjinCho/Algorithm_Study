import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-21.
 */
public class WhiteBlock {
    public static void main(String [] args)
    {
        String lines[] = new String[8];
        Scanner sc= new Scanner(System.in);

        for(int i=0;i<8;i++)
            lines[i] = sc.nextLine();
        boolean flag = true;

        int ans = 0;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(flag&&lines[i].charAt(j) =='F')
                {
                    ans++;
                }
                flag=!flag;
            }
            flag=!flag;
        }
        System.out.println(ans);
    }


}
