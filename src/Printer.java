import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-26.
 */
public class Printer {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int count = line.length()*2;

        for(int i=1;i<line.length()-1;i++)
        {
            if(i<line.length()-1 && line.charAt(i-1)==line.charAt(i+1))
                count--;
            if(line.charAt(i-1)==line.charAt(i))
                count--;
        }
        System.out.println(count);
    }

}
