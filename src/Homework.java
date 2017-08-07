import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-07.
 */
public class Homework {

    //LABCD , L일동안 A , B  - > C, D 해야된다.

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int L,A,B,C,D;
        L = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        D = sc.nextInt();
        int t1 = A/C;
        int t2 = B/D;
        if(A%C !=0)
            t1++;
        if(B%D != 0)
            t2++;
        L = L - Math.max(t1,t2);
        System.out.println(L);
    }
}
