import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-25.
 */
public class Ant {

    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        int l1 = sc.nextInt();
        int l2 = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String b = sc.nextLine();
        char [] str = new char[l1+l2];
        boolean check[] = new boolean[l1+l2];
        for(int j=0;j<l1;j++) {
            str[j] = a.charAt(l1 - j - 1);
            check[j] = false;
        }
        for(int j=0;j<l2;j++) {
            str[j + l1] = b.charAt(j);
            check[j+l1] = true;
        }
        int T = sc.nextInt();
        for(int i=1;i<=T;i++)
        {
            for(int j=0;j<l1+l2-1;j++)
            {
                if(false==check[j] && check[j+1]==true)
                {
                    check[j]=!check[j];
                    check[j+1]=!check[j+1];
                    char tmp = str[j];
                    str[j]=str[j+1];
                    str[j+1] = tmp;
                    j++;
                }
            }
        }
        for(int i=0;i<l1+l2;i++)
            System.out.print(str[i]);
    }
}
