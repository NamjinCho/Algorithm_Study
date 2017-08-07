import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-08-07.
 */
public class Keyloger {

    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int tc = 0 ; tc<T;tc++) {
            String line = sc.nextLine();
            char[] str = line.toCharArray();
            int N = line.length();
            String list = "";
            int ptr = 0;

            for (int i = 0; i < N; i++) {
                if (str[i] == '<') {
                    ptr--;
                    if (ptr < 0)
                        ptr = 0;
                } else if (str[i] == '>') {
                    ptr++;
                    if (ptr > list.length())
                        ptr = list.length();
                } else if (str[i] == '-') {

                    ptr--;
                    if(ptr<0)
                        ptr = 0;
                    String t1=list.substring(0,ptr);
                    String t2="";
                    if(ptr+2 < list.length())
                        t2 = list.substring(ptr+2,list.length());

                    list = t1 + t2;
                    if (ptr < 0)
                        ptr = 0;
                } else {
                    list = list.substring(0, ptr) + str[i] + list.substring(ptr, list.length());
                    ptr++;
                }
            }
            System.out.println(list);
        }

    }


}
