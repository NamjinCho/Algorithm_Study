import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-04.
 */
public class Calculate {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] sub = line.split(" ");

        BigInteger A,B,C,two;
        A = new BigInteger(sub[0]);
        B = new BigInteger(sub[1]);
        C = new BigInteger(sub[2]);
        two = new BigInteger("2");
        //C.mod(two);
        if(C.mod(two).intValue()==0)
            System.out.println(A.toString());
        else {

            System.out.println(A.xor(B));
        }
    }
}
