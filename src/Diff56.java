import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-09-22.
 */
public class Diff56 {
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        String line = sc.nextLine();
        String sub[] = line.split(" ");

        String []min = new String[2];
        String []max = new String[2];
        for(int i=0;i<2;i++) {
            min[i] = sub[i].replaceAll("6", "5");
            max[i] = sub[i].replaceAll("5","6");
        }
        int ans1 = Integer.parseInt(min[0]) + Integer.parseInt(min[1]);
        int ans2 = Integer.parseInt(max[0]) + Integer.parseInt(max[1]);
        System.out.println(ans1 + " " + ans2);
    }
}
